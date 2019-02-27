package com.wbb.user.feign;

import dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import service.OrderService;

/**
 * Created by mavlarn on 2018/2/14.
 */
@FeignClient(value = "order", path = "/api/order")
public interface OrderClient extends OrderService {

    @GetMapping("/{id}")
    OrderDTO getById(@PathVariable(name = "id") Integer id);

    @PostMapping("")
    OrderDTO create(@RequestBody OrderDTO dto);
}
