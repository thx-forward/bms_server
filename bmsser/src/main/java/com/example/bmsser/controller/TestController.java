package com.example.bmsser.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bmsser.entity.Stu;
import com.example.bmsser.repository.StuRepository;
import com.example.bmsser.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    RedisUtils redisUtils = null;

    @Autowired
    StuRepository userRepository = null;

    @GetMapping("/test")
    public String testInter() {
        JSONObject object = new JSONObject();
        object.put("type","test");
        object.put("content","hello world");
        return object.toJSONString();
    }

    @GetMapping("/testredis")
    public String testRedis(){
        redisUtils.set("testRedis","message");
        return "123";
    }

    @GetMapping("/testhive")
    public String testHive() {
        List<Stu> stuList = userRepository.selectAllStu();
        return JSONArray.toJSONString(stuList);
    }
}
