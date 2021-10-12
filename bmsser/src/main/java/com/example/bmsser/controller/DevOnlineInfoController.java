package com.example.bmsser.controller;

import com.example.bmsser.controller.bean.RunningInfoBrief;
import com.example.bmsser.utils.RedisUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rt")
public class DevOnlineInfoController {

    @Autowired
    RedisUtils redisUtils = null;

    @GetMapping("/getRunInfoBrief")
    @ResponseBody
    @ApiOperation(value = "获取设备运行信息")
    public RunningInfoBrief getRunInfoBrief() {
        RunningInfoBrief brief = new RunningInfoBrief();
        brief.setStations(100);
        brief.setFailures(0);
        brief.setPacks(100);
        brief.setOnline(Integer.valueOf(redisUtils.get("onlineDevNum")));
        return brief;
    }
}
