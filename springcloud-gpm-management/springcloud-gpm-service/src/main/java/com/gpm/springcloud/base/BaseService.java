package com.gpm.springcloud.base;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author Don
 * @Date: 2020/7/8 15:30
 * Discription:通用Service
 * @Version 1.0
 **/
public abstract class BaseService<T> {
    @Autowired
    private Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

}
