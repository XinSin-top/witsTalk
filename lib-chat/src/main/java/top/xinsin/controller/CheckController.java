package top.xinsin.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.xinsin.pojo.User;
import top.xinsin.services.UserService;

import java.util.Date;
import java.util.HashMap;

/**
 * @Auther wzp
 * @Date 2021/12/12 10:49
 * @Version 1.0
 */
@RestController
public class CheckController {
    private final Logger logger = LogManager.getLogger(CheckController.class);
    @Autowired
    UserService userService;
    public static HashMap<User, Date> checklist = new HashMap<>();
    @PostMapping("/api/check")
    public String Check(@RequestBody User user){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);
        checklist.put(user,new Date());
        jsonObject.put("data",checklist.get(user));
        userService.setOnline(user);
        logger.info("check");
        return jsonObject.toJSONString();
    }
}