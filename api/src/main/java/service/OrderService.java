package service;


import dto.OrderDTO;

public interface OrderService {

    OrderDTO create(OrderDTO dto);
    OrderDTO getById(Integer id);
}
