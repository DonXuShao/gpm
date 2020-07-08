package com.gpm.springcloud.base;

/**
 * @Author Don
 * @Date: 2020/7/8 16:52
 * @Discription:
 * @Version 1.0
 **/
public abstract class CommonController<T> extends BaseController {

    public abstract BaseService<T> getBaseService();

}
