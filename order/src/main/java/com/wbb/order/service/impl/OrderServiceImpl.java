package com.wbb.order.service.impl;

import com.wbb.order.dao.OrderRepository;
import com.wbb.order.domain.Order;
import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrderService;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderDTO create(OrderDTO dto) {
        Order order = new Order();
        order.setAmount(dto.getAmount());
        order.setTitle(dto.getTitle());
        order.setDetail(dto.getDetail());
        order = orderRepository.save(order);
        dto.setId(order.getId());
        return dto;
    }




    @Override
    @Transactional
    public OrderDTO getById(Integer id) {
        Optional<Order> optional = orderRepository.findById(id);
        Order order = optional.get();
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setAmount(order.getAmount());
        dto.setTitle(order.getTitle());
        dto.setDetail(order.getDetail());
        return dto;
    }
}
