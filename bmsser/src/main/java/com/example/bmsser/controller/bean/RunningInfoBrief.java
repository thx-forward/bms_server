package com.example.bmsser.controller.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(value = "设备在线运行信息")
public class RunningInfoBrief {
    @ApiModelProperty(value = "监测站点数")
    private int stations;
    @ApiModelProperty(value = "出现故障的站点数")
    private int failures;
    @ApiModelProperty(value = "总的电池组数")
    private int packs;
    @ApiModelProperty(value = "在线数")
    private int online;
}
