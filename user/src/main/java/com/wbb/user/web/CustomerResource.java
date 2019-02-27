package com.wbb.user.web;

import com.wbb.user.dao.CustomerRepository;
import com.wbb.user.domain.Customer;
import com.wbb.user.feign.OrderClient;
import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mavlarn on 2018/1/20.
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerResource {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderClient orderClient;


    @PostConstruct
    public void init() {
        Customer customer = new Customer();
        customer.setUsername("wbb");
        customer.setPassword("123456");
        customer.setRole("User");
        customerRepository.save(customer);
    }



    @PostMapping("")
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/my")
    public Map getMyInfo() {
        Customer customer = customerRepository.findOneByUsername("wbb");
        OrderDTO order = orderClient.getById(1);
        Map result = new HashMap();
        result.put("customer", customer);
        result.put("order", order);
        return result;
    }

}
