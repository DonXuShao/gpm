package com.gpm.springcloud.fallback;

import com.github.pagehelper.PageInfo;
import com.gpm.springcloud.base.ResultData;
import com.gpm.springcloud.service.SpringCloudService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Don
 * @Description 该类用作熔断时执行的备份方法
 * @Date 2020/7/13 14:38
 **/
//@Component
public class SpringCloudServiceFallBack implements FallbackFactory<SpringCloudService> {
    /**
     * 该方法就是用于熔断的方法
     *
     * @param throwable
     * @return
     */
    public SpringCloudService create(Throwable throwable) {
        SpringCloudService springCloudService = new SpringCloudService() {
            public ResultData selectAll() {
                return null;
            }
        };
        return springCloudService;
    }
}
