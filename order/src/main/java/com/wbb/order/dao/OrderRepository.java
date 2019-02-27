package com.wbb.order.dao;

import com.wbb.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mavlarn on 2018/1/20.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findOneByTitle(String title);
}
