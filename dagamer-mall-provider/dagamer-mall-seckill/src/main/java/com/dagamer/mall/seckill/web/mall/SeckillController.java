package com.dagamer.mall.seckill.web.mall;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seckill")
public class SeckillController {

    @RequestMapping("/product")
    public void seckillProduct() {
        System.out.println("seckillProduct");
    }

}
