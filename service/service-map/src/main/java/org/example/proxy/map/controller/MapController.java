package org.example.proxy.map.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.example.proxy.common.result.Result;
import org.example.proxy.map.service.MapService;
import org.example.proxy.model.form.map.CalculateDrivingLineForm;
import org.example.proxy.model.vo.map.DrivingLineVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "地图API接口管理")
@RestController
@RequestMapping("/map")
@SuppressWarnings({"unchecked", "rawtypes"})
public class MapController {

    @Autowired
    private MapService mapService;

    @Operation(summary = "计算驾驶线路")
    @PostMapping("/calculateDrivingLine")
    public Result<DrivingLineVo> calculateDrivingLine(@RequestBody CalculateDrivingLineForm
                                                                  calculateDrivingLineForm) {
        DrivingLineVo drivingLineVo = mapService.calculateDrivingLine(calculateDrivingLineForm);
        return Result.ok(drivingLineVo);
    }
}

