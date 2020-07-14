package com.gpm.springcloud.controller;

import com.gpm.springcloud.base.BaseService;
import com.gpm.springcloud.base.CommonController;
import com.gpm.springcloud.base.ResultData;
import com.gpm.springcloud.model.Score;
import com.gpm.springcloud.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.gpm.springcloud.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @Author Don
 * @Date: 2020/7/14 19:28
 * @Discription:
 * @Version 1.0
 **/
@RestController
public class ScoreController extends CommonController<Score> {

    @Autowired
    private ScoreService scoreService;

    @Override
    public BaseService<Score> getBaseService() {
        return scoreService;
    }

    /**
     * @Author Don
     * @Description 评分记录
     * @Date 2020/7/14 10:40
     **/
    @GetMapping("/selectScoreRecords")
    public ResultData selectScoreRecords(@RequestParam Map map) {
        Map<String, Object> resultMap = scoreService.selectScoreRecords(map);
        if (SELECT_DATA_SUCCESS.getCode().equals(resultMap.get("code"))) {
            return super.selectSuccess(resultMap.get("data"));
        } else {
            return super.selectFailed();
        }
    }


}
