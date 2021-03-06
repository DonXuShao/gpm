package com.gpm.springcloud.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gpm.springcloud.base.BaseService;
import com.gpm.springcloud.mapper.AuditMapper;
import com.gpm.springcloud.model.Audit;
import com.gpm.springcloud.model.MappingUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gpm.springcloud.status.SelectStatus.SELECT_DATA_FAILED;
import static com.gpm.springcloud.status.SelectStatus.SELECT_DATA_SUCCESS;

/**
 * @Author Don
 * @Date: 2020/7/14 21:45
 * @Discription:审核记录Service
 * @Version 1.0
 **/
@Service
public class AuditService extends BaseService<Audit> {
    @Autowired
    private AuditMapper auditMapper;

    /**
     * @Author Don
     * @Description  查询审核记录列表
     * @Date 2020/7/14 21:46 
     **/
    public Map<String, Object> selectAuditRecords(Map map) {
        HashMap<String, Object> resultMap = new HashMap<>();

        MappingUnit tMappingUnit = new MappingUnit();
        if (null != map.get("id")) {
            tMappingUnit.setId(Long.parseLong(map.get("id") + ""));
        }

        List<HashMap> resultdata = auditMapper.selectAuditRecords(tMappingUnit);
        PageHelper.startPage(Integer.parseInt(map.get("currentPage") + ""), Integer.parseInt(map.get("pageSize") + ""));
        PageInfo pageInfo = new PageInfo(resultdata);
        if (resultdata != null && resultdata.size() > 0) {
            resultMap.put("code", SELECT_DATA_SUCCESS.getCode());
            resultMap.put("msg", SELECT_DATA_SUCCESS.getMsg());
            resultMap.put("data", pageInfo);
        } else {
            resultMap.put("code", SELECT_DATA_FAILED.getCode());
            resultMap.put("msg", SELECT_DATA_FAILED.getMsg());
        }
        return resultMap;
    }
}
