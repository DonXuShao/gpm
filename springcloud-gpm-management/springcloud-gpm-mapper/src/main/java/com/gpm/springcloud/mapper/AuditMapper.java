package com.gpm.springcloud.mapper;

import com.gpm.springcloud.model.Audit;
import com.gpm.springcloud.model.MappingUnit;
import com.gpm.springcloud.model.Technicist;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author Don
 * @Date: 2020/7/14 21:38
 * @Discription: 审核记录表
 * @Version 1.0
 **/
@Repository
public interface AuditMapper extends Mapper<Audit> {
    /**
     * @Author Don
     * @Description  审核记录列表
     * @Date 2020/7/14 21:39 
     **/
    List<HashMap> selectAuditRecords(MappingUnit tMappingUnit);
}
