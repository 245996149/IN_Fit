package cn.infit.ll.controller;

import cn.infit.ll.dao.UserDao;
import cn.infit.ll.dao.UtilDao;
import cn.infit.ll.dbentity.UsersEntity;
import cn.infit.ll.weChatEntity.WeChatWebUserInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static cn.infit.ll.util.SMSUtil.sendSMS;

/**
 * Created by kaxia on 2017/6/16.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private static Logger logger = Logger.getLogger(TestController.class);

    @Resource
    UserDao userDao;

    @Resource
    UtilDao utilDao;

    @RequestMapping("/toBindingPhone.do")
    public String toBindingPhone() {
        return "mobile/binding_phone";
    }

    @RequestMapping("/getCode.do")
    @ResponseBody
    public Map<String, Object> getCode(String phone, HttpSession session) {

        Map<String, Object> result = new HashMap<>();

        if (phone == null || "".equals(phone)) {

            result.put("success", false);
            result.put("message", "手机号不能为空");
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
            // sendSMS(codeTemp, phone);

            result.put("success", true);

        } catch (Exception e) {

            e.printStackTrace();
            result.put("success", false);
            result.put("message", "发生未知错误，请稍后再试！");

        }

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
            return result;
        }

        if (!code.equals(sessionCode)) {
            result.put("success", false);
            result.put("message", "验证码不正确!");
            return result;
        }

        // 从session中取出微信用户信息
        //WeChatWebUserInfo webUserInfo = (WeChatWebUserInfo) session.getAttribute("webUserInfo");

        UsersEntity user = userDao.findByUser_phone(phone);

        if (user == null) {

            user = new UsersEntity();

            user.setUserPhone(phone);
            user.setUserPass(password);

        } else {

            user.setUserPass(password);

        }

        // 将微信信息写入对象
//        user.setWechatOpenid(webUserInfo.getOpenId());
//        user.setWechatHeadimgurl(webUserInfo.getHeadImgUrl());
//        user.setWechatCity(webUserInfo.getCity());
//        user.setWechatNickname(webUserInfo.getNickname());
//        user.setWechatProvince(webUserInfo.getProvince());

        if (!utilDao.update(user)) {

            result.put("success", false);
            result.put("message", "对象写入数据库失败");
            return result;

        }

        result.put("success", true);
        System.out.println(result.toString());

        return result;

    }

}
