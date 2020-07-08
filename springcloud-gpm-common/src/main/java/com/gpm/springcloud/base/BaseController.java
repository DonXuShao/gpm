package com.gpm.springcloud.base;

import static com.gpm.springcloud.status.LoginStatus.*;


/**
 * @Author Don
 * @Date: 2020/7/8 14:48
 * Discription: 统一Controller
 * 也就是说所有的controller都需要继承这个controller，进行统一返回
 **/

public class BaseController {


    /**
     * @return
     * @Author Don
     * @Description 登录成功
     * 使用系统消息
     * @Date 2020/7/8 15:06
     * @Param
     **/
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @return
     * @Author Don
     * @Description 登录成功 自定义消息
     * @Date 2020/7/8 15:07
     * @Param
     **/
    protected ResultData loginSuccess(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @return
     * @Author Don
     * @Description 登录成功
     * 返回数据信息 使用系统消息
     * @Date 2020/7/8 15:07
     * @Param
     **/
    protected ResultData loginSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @return
     * @Author Don
     * @Description 返回数据信息
     * 使用自定义消息
     * @Date 2020/7/8 15:08
     * @Param
     **/
    protected ResultData loginSuccess(String msg, Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @return
     * @Author Don
     * @Description 登录失败
     * 使用系统消息
     * @Date 2020/7/8 15:09
     * @Param
     **/
    protected ResultData loginFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * @Author Don
     * @Description 登录失败
     * 使用系统消息 详细说明
     * @Date 2020/7/8 15:25
     * @Param
     * @Return
     * @Throws
     **/
    protected ResultData loginFailed(String detail) {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);
        return resultData;
    }
}
