package com.gpm.springcloud.base;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author Don
 * @Date: 2020/7/8 16:52
 * @Discription:
 * @Version 1.0
 **/
public abstract class CommonController<T> extends BaseController {

    public abstract BaseService<T> getBaseService();

    /**
     * @Author Don
     * @Description 在新增前需要执行的操作
     * @Date 2020/7/9 19:01
     **/
    protected void beforeAdd(Map map) {
        // TODO AddMethod Before add new data
    }

    /**
     * @Author Don
     * @Description 在新增方法后执行的操作
     * @Date 2020/7/9 19:03
     **/
    protected void afterAdd(Map map) {
        //TODO After AddMethod
    }


    /**
     * @Author Don
     * @Description 通用新增方法
     * @Date 2020/7/9 19:05
     **/
    public ResultData add(@RequestBody Map map) {
        beforeAdd(map);
        //1.Map转换为实体类
        T instance = getBaseService().newInstance(map);
        //2.通用Serveice
        Integer addResult = getBaseService().add(instance);
        if (addResult > 0) {
            afterAdd(map);
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @Author Don
     * @Description 通用删除方法
     * @Date 2020/7/9 19:07
     **/
    public ResultData delete(@RequestBody Map map) {
        T instance = getBaseService().newInstance(map);
        Integer deleteResult = getBaseService().delete(instance);
        if (deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }

    /**
     * @Author Don
     * @Description 批量删除
     * @Date 2020/7/9 19:09
     **/
    public ResultData batchDelete(@RequestParam("ids[]") Integer[] ids) {
        Integer deleteResult = getBaseService().deleteByIds(Arrays.asList(ids));
        if (deleteResult > 0) {
            return super.operationSuccess();
        }
        return super.operationFailed();
    }
}
