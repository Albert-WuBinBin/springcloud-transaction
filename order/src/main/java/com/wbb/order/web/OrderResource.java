package com.wbb.order.web;

import com.wbb.order.dao.OrderRepository;
import com.wbb.order.domain.Order;
import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.OrderService;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by mavlarn on 2018/1/20.
 */
@RestController
@RequestMapping("/api/order")
public class OrderResource implements OrderService {

    @Autowired
    OrderService orderService;

    @PostConstruct
    public void init() {
        Order order = new Order();
        order.setId(1);
        order.setAmount(100);
        order.setTitle("MyOrder");
        order.setDetail("aaa");
        orderRepository.save(order);
    }

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("")
    public OrderDTO create(@RequestBody OrderDTO dto) {
        orderService.create(dto);
        return dto;
    }

    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable Integer id) {
        return orderService.getById(id);
    }

    @GetMapping("")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

}
