package cn.infit.ll.controller;

import cn.infit.ll.dao.UserDao;
import cn.infit.ll.dao.UserDataDao;
import cn.infit.ll.dao.UtilDao;
import cn.infit.ll.dbentity.UserDataEntity;
import cn.infit.ll.dbentity.UsersEntity;
import cn.infit.ll.util.Sha1;
import cn.infit.ll.weChatEntity.JsapiTicket;
import cn.infit.ll.weChatEntity.WeChatOauth2Token;
import cn.infit.ll.weChatEntity.WeChatWebUserInfo;
import cn.infit.ll.weChatUtil.WeChatWebUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import static cn.infit.ll.util.DirUtil.getConfigInfo;
import static cn.infit.ll.util.DirUtil.getErrorInfoFromException;
import static cn.infit.ll.util.SMSUtil.sendSMS;

/**
 * Created by kaxia on 2017/6/16.
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    private static Logger logger = Logger.getLogger(ViewController.class);

    String appid = getConfigInfo("appid");
    String appsecret = getConfigInfo("appsecret");

    @Resource
    UserDao userDao;

    @Resource
    UserDataDao userDataDao;

    @Resource
    UtilDao utilDao;

    @RequestMapping("/toWeChatLogin.do")
    public void toWeChatCheckin(HttpServletRequest request, HttpServletResponse response) {
        try {
            StringBuffer url = request.getRequestURL();
            String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length())
                    .append(request.getContextPath()).append("/view/").toString();
            String redirectURL = "https://open.weixin.qq.com/connect/oauth2/authorize?" + "appid=" + appid
                    + "&redirect_uri=" + URLEncoder.encode(tempContextUrl + "login.do", "utf-8")
                    + "&response_type=code&scope=snsapi_userinfo&state=" + 000 + "&connect_redirect=1#wechat_redirect";
            logger.info("跳转到微信授权认证服务器：" + redirectURL);
            response.sendRedirect(redirectURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login.do")
    public String weChatCheckin(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session)
            throws UnsupportedEncodingException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try {

            // 用户同意授权后，能获取到code
            String code = request.getParameter("code");

            String state = request.getParameter("state");

            // 用户不同意授权
            if ("authdeny".equals(code)) {
                //TODO 添加跳转到用户不同意授权提示页面
                return "mobile/404";
            }

            // 获取网页授权access_token
            WeChatOauth2Token weixinOauth2Token = WeChatWebUtil.getOauth2AccessToken(appid, appsecret, code);

            // 获取网页授权access_token失败，跳转到提示页面
            if (weixinOauth2Token == null) {
                //TODO 添加跳转到失败提示页面
                logger.info("主流程中---------->" + "获取网页授权access_token：失败");
                return "mobile/404";
            }

            logger.info("主流程中---------->" + "获取到的WebToken参数：" + weixinOauth2Token.toString());

            // 网页授权接口访问凭证
            String webToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
            WeChatWebUserInfo webUserInfo = WeChatWebUtil.getWebUserInfo(webToken, openId);

            if (webUserInfo == null) {

                //TODO 添加跳转到失败提示页面
                logger.info("主流程中---------->" + "获取webUserInfo参数：失败");
                return "mobile/404";

            }

            logger.info("主流程中---------->获取到的webUserInfo参数：" + webUserInfo.toString());

            UsersEntity user = userDao.findByOpen_id(webUserInfo.getOpenId());

            // 判断该用户是否为首次登陆
            if (user == null) {

                session.setAttribute("webUserInfo", webUserInfo);
                // 首次登陆，跳转到绑定手机号逻辑
                // TODO 跳转到绑定手机号逻辑
                return "mobile/binding_phone";

            }

            session.setAttribute("user", user);

            return "redirect:/view/toTable.do";

        } catch (Exception e) {

            e.printStackTrace();
            logger.info("主流程中---------->发生未知错误，错误信息为：" + getErrorInfoFromException(e));
            return "mobile/404";
        }
    }

    @RequestMapping("/toTable.do")
    // @ResponseBody
    public String toTable(HttpSession session, Model model) {

        UsersEntity user = (UsersEntity) session.getAttribute("user");

        UserDataEntity userDataEntity = userDataDao.findByUser_idOrderCreate_time(user.getId());

        model.addAttribute("user_data", userDataEntity);

        return "mobile/table";

    }


    @RequestMapping("/getCode.do")
    @ResponseBody
    public Map<String, Object> getCode(String phone, HttpSession session) {

        Map<String, Object> result = new HashMap<>();

        if (phone == null || "".equals(phone)) {

            result.put("success", false);
            result.put("message", "手机号不能为空");
            logger.info(result);
            return result;

        }

        UsersEntity user = userDao.findByUser_phone(phone);

        if (user == null) {

            result.put("success", false);
            result.put("message", "该手机号未进行过测量，无法绑定登陆");
            logger.info(result);
            return result;

        }

        try {

            // 从session中取出发送次数
            Map<String, Integer> phoneNum = (Map<String, Integer>) session.getAttribute("phoneNum");

            // 判断发送次数
            if (phoneNum != null) {

                Integer num = phoneNum.get(phone);

                if (num == null) {
                    num = 1;
                } else {
                    num++;
                }

                if (num > 3) {
                    result.put("success", false);
                    result.put("message", "今天已经超过发送限制了哦！");
                    logger.info(result);
                    return result;
                }
                phoneNum.put(phone, num);
            } else {
                phoneNum = new HashMap<>();
                phoneNum.put(phone, 1);
            }

            // 创建6位验证码字符串对象
            String codeTemp = "";
            Random random = new Random();

            // 生成6位随机码
            for (int i = 0; i < 6; i++) {
                codeTemp += random.nextInt(9);
            }

            Map<String, String> codeMap = new HashMap<>();

            codeMap.put(phone, codeTemp);

            session.setAttribute("phoneCode", codeMap);

            session.setAttribute("phoneNum", phoneNum);

            System.out.println(codeMap.toString());

            // TODO 添加发送短信逻辑
            sendSMS(codeTemp, phone);

            result.put("success", true);

        } catch (Exception e) {

            e.printStackTrace();
            result.put("success", false);
            result.put("message", "发生未知错误，请稍后再试！");

        }
        logger.info(result);
        return result;

    }

    @RequestMapping("/checkCode.do")
    @ResponseBody
    public Map<String, Object> checkCode(String phone, String code, String password, HttpSession session) {
        // 设置返回的Map
        Map<String, Object> result = new HashMap<>();

        Map<String, String> codeMap = (Map<String, String>) session.getAttribute("phoneCode");

        String sessionCode = codeMap.get(phone);

        if ("".equals(sessionCode) || sessionCode == null) {
            result.put("success", false);
            result.put("message", "未找到对应的验证码!");
            logger.info(result);
            return result;
        }

        if (!code.equals(sessionCode)) {
            result.put("success", false);
            result.put("message", "验证码不正确!");
            logger.info(result);
            return result;
        }

        // 从session中取出微信用户信息
        WeChatWebUserInfo webUserInfo = (WeChatWebUserInfo) session.getAttribute("webUserInfo");

        UsersEntity user = userDao.findByUser_phone(phone);

        if (user == null) {

            user = new UsersEntity();

            user.setUserPhone(phone);
            user.setUserPass(password);

        } else {

            user.setUserPass(password);

        }

        // 将微信信息写入对象
        user.setWechatOpenid(webUserInfo.getOpenId());
        user.setWechatHeadimgurl(webUserInfo.getHeadImgUrl());
        user.setWechatCity(webUserInfo.getCity());
        user.setWechatNickname(webUserInfo.getNickname());
        user.setWechatProvince(webUserInfo.getProvince());

        if (!utilDao.update(user)) {

            result.put("success", false);
            result.put("message", "对象写入数据库失败");
            logger.info(result);
            return result;

        }

        System.out.println(user.toString());

        session.setAttribute("user", user);

        result.put("success", true);
        logger.info(result);

        return result;

    }


    /**
     * 生成获取微信jssdk所需参数反馈给客户端
     *
     * @param response
     * @param request
     * @param url      当前页面url
     * @return
     */
    @RequestMapping("/getWeChatInfo.do")
    @ResponseBody
    public Map<String, String> weChat(HttpServletResponse response, HttpServletRequest request, String url) {

        logger.info("接收到生成获取微信jssdk的请求---------->请求的url为：" + url);

        return WXConfig(request, response, url);

    }

    /**
     * 获取微信jssdk所需参数
     *
     * @param request
     * @param response
     * @return
     */
    private HashMap<String, String> WXConfig(HttpServletRequest request, HttpServletResponse response, String url) {

        HashMap<String, String> res = new HashMap<>();

        String time = null;

        String jsapi_ticket = null;

        String signature = "";

        String nonce_str = "";

        try {

            JsapiTicket ticket = WeChatWebUtil.judgeJsapiTicketOvertime(request, response);
            // 获取随机数
            nonce_str = UUID.randomUUID().toString();
            // 获取jsapi_ticket
            jsapi_ticket = ticket.getTicket();
            // 获取系统时间
            time = String.valueOf(System.currentTimeMillis()).substring(0, 10);
            // 合成字符串用于签名
            String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + time + "&url=" + url;

            signature = Sha1.getSha1(str);

            logger.info("获取微信jssdk参数---------->合成的字符串为：" + str + "；签名后的字符串为：" + signature);

        } catch (Exception e) {

            e.printStackTrace();
            logger.info("获取微信jssdk参数---------->发生未知错误，错误信息为：" + getErrorInfoFromException(e));

        }

        res.put("appid", appid);
        res.put("url", url);
        res.put("jsapi_ticket", jsapi_ticket);
        res.put("nonceStr", nonce_str);
        res.put("timestamp", time);
        res.put("signature", signature);

        logger.info("获取微信jssdk参数---------->返回的参数为：" + res.toString());

        return res;

    }

}
