package com.wbb.user.dao;

import com.wbb.user.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by mavlarn on 2018/1/20.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findOneByUsername(String username);
}
