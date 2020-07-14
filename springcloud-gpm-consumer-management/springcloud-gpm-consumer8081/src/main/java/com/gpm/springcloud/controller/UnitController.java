package com.gpm.springcloud.controller;

import com.gpm.springcloud.service.SpringCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author Don
 * @Date: 2020/7/13 14:37
 * @Discription:Consumer unitController
 * @Version 1.0
 **/
@RestController
public class UnitController {

    @Autowired
    private SpringCloudService springCloudService;




}
