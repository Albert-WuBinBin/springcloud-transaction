package com.wbb.order.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mavlarn on 2018/2/14.
 */
@RestController
@RequestMapping("/order/home")
public class HomeResource {

    @GetMapping("")
    public String get() {
        return "order!";
    }
}
