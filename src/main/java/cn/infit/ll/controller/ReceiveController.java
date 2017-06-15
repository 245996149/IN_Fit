package cn.infit.ll.controller;

import cn.infit.ll.dao.UserDao;
import cn.infit.ll.dao.UtilDao;
import cn.infit.ll.dbentity.UserDataEntity;
import cn.infit.ll.dbentity.UsersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kaxia on 2017/6/14.
 */
@Controller
@RequestMapping("/receive")
public class ReceiveController {

    @Resource
    UserDao userDao;

    @Resource
    UtilDao utilDao;

    @RequestMapping("/receiveData.do")
    @ResponseBody
    public Map<String, Object> receiveData(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Map<String, Object> result = new HashMap<>();

        try {

            String user_phone = request.getParameter("user_phone");

            // 接收手机号，判断是否为空
            if (user_phone == null || "".equals(user_phone)) {

                // 为空直接返回
                result.put("success", false);
                result.put("code", 100);
                result.put("message", "user_phone为空");
                return result;

            }

            // 查询该手机号对应的用户
            UsersEntity user = userDao.findByUser_phone(user_phone);

            if (user == null) {

                user = new UsersEntity();
                user.setUserPhone(user_phone);
                String user_sex = request.getParameter("sex");
                if ("men".equals(user_sex)) {
                    user.setSex("1");
                } else {
                    user.setSex("2");
                }
                utilDao.save(user);

            }

            UserDataEntity userData = new UserDataEntity();

            userData.setUserId(user.getId());
            userData.setWeight(new BigDecimal(request.getParameter("weight")));
            userData.setHeight(new BigDecimal(request.getParameter("height")));
            userData.setHighWaist(new BigDecimal(request.getParameter("high_waist")));
            userData.setAnkleHigh(new BigDecimal(request.getParameter("ankle_high")));
            userData.setKneeHigh(new BigDecimal(request.getParameter("knee_high")));
            userData.setDoesHigh(new BigDecimal(request.getParameter("does_high")));
            userData.setHipHigh(new BigDecimal(request.getParameter("hip_high")));
            userData.setFeetLong(new BigDecimal(request.getParameter("feet_long")));
            userData.setBackLength(new BigDecimal(request.getParameter("back_length")));
            userData.setFrontWaistLength(new BigDecimal(request.getParameter("front_waist_length")));
            userData.setChestLong(new BigDecimal(request.getParameter("chest_long")));
            userData.setChestWidth(new BigDecimal(request.getParameter("chest_width")));
            userData.setBackWidth(new BigDecimal(request.getParameter("back_width")));
            userData.setShoulderLength(new BigDecimal(request.getParameter("shoulder_length")));
            userData.setHipWaistLong(new BigDecimal(request.getParameter("hip_waist_long")));
            userData.setTheThighInsideLong(new BigDecimal(request.getParameter("the_thigh_inside_long")));
            userData.setArmLength(new BigDecimal(request.getParameter("arm_length")));
            userData.setUpperArmLength(new BigDecimal(request.getParameter("upper_arm_length")));
            userData.setLengthOfTheTrunk(new BigDecimal(request.getParameter("length_of_the_trunk")));
            userData.setForkLength(new BigDecimal(request.getParameter("fork_length")));
            userData.setHeadCircumference(new BigDecimal(request.getParameter("head_circumference")));
            userData.setNeckCircumference(new BigDecimal(request.getParameter("neck_circumference")));
            userData.setOnTheChest(new BigDecimal(request.getParameter("on_the_chest")));
            userData.setTheChest(new BigDecimal(request.getParameter("the_chest")));
            userData.setUnderTheChest(new BigDecimal(request.getParameter("under_the_chest")));
            userData.setOnTheWaistWaistInTheNet(new BigDecimal(request.getParameter("on_the_waist_waist_in_the_net")));
            userData.setInTheWaist(new BigDecimal(request.getParameter("in_the_waist")));
            userData.setWaistbandIsSurrounded(new BigDecimal(request.getParameter("waistband_is_surrounded")));
            userData.setHipCircumference(new BigDecimal(request.getParameter("hip_circumference")));
            userData.setThighCircumference(new BigDecimal(request.getParameter("thigh_circumference")));
            userData.setInTheThighCircumference(new BigDecimal(request.getParameter("in_the_thigh_circumference")));
            userData.setKneeCircumference(new BigDecimal(request.getParameter("knee_circumference")));
            userData.setAnkleCircumference(new BigDecimal(request.getParameter("ankle_circumference")));
            userData.setHeelsCircumference(new BigDecimal(request.getParameter("heels_circumference")));
            userData.setArmRhizosphere(new BigDecimal(request.getParameter("arm_rhizosphere")));
            userData.setUpperArmCircumference(new BigDecimal(request.getParameter("upper_arm_circumference")));
            userData.setElbowCircumference(new BigDecimal(request.getParameter("elbow_circumference")));
            userData.setWristCircumference(new BigDecimal(request.getParameter("wrist_circumference")));
            userData.setHemCircumference(new BigDecimal(request.getParameter("hem_circumference")));
            userData.setFootMouth(new BigDecimal(request.getParameter("foot_mouth")));
            userData.setBeforeTheLength(new BigDecimal(request.getParameter("before_the_length")));
            userData.setAfterTheLength(new BigDecimal(request.getParameter("after_the_length")));
            userData.setSleeveLength(new BigDecimal(request.getParameter("sleeve_length")));
            userData.setLength(new BigDecimal(request.getParameter("length")));
            userData.setStraightCrotch(new BigDecimal(request.getParameter("straight_crotch")));

            System.out.println(utilDao.save(userData));

            System.out.println(userData.toString());

            result.put("success", true);
            result.put("code", 200);
            result.put("message", "接受成功");

            return result;

        } catch (NullPointerException e) {

            // 空指针异常，返回
            e.printStackTrace();
            result.put("success", false);
            result.put("code", 100);
            result.put("message", "有参数为空");
            return result;

        }

    }

}
