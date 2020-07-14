package com.gpm.springcloud.controller;

import com.gpm.springcloud.base.BaseService;
import com.gpm.springcloud.base.CommonController;
import com.gpm.springcloud.base.ResultData;
import com.gpm.springcloud.model.MappingUnit;
import com.gpm.springcloud.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static com.gpm.springcloud.status.SelectStatus.*;

/**
 * @Author Don
 * @Date: 2020/7/13 11:22
 * @Discription:单位操作Controller
 * @Version 1.0
 **/
@RestController
public class UnitController extends CommonController<MappingUnit> {
    @Autowired
    private UnitService unitService;

    @Override
    public BaseService<MappingUnit> getBaseService() {
        return unitService;
    }

    /**
     * @Author Don
     * @Description 查询表中所有数据
     * @Date 2020/7/13 19:40
     **/
    @GetMapping("/selectAll")
    public ResultData selectAll() {
        List<MappingUnit> list = unitService.selectAll();
        if (null != list || list.size() > 0) {
            return super.operationSuccess(list);
        } else {
            return super.operationFailed("查询失败");
        }
    }

    /**
     * @Author Don
     * @Description 按条件查询单位
     * @Date 2020/7/14 10:40
     **/
    @GetMapping("/selectUnit")
    public ResultData selectUnit(@RequestParam Map map) {
        Map<String, Object> resultMap = unitService.selectUnit(map);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.selectSuccess(resultMap.get("data"));
        } else {
            return super.selectFailed();
        }
    }


}
