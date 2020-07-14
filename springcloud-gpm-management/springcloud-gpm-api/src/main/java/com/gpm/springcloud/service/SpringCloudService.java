package com.gpm.springcloud.service;


import com.gpm.springcloud.base.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @Author Don
 * @Date: 2020/7/13 11:28
 * @Discription:
 * @Version 1.0
 **/
@FeignClient(value = "gpm-interface")
public interface SpringCloudService {

    @GetMapping("/selectAll")
    ResultData selectAll();
}
