package com.dagamer.mall.seckill.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeckillController {

    @RequestMapping(value = "seckill", method = RequestMethod.GET)
    public void seckill() {

    }

}
