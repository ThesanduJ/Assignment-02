package org.example.assignment02.service;

import org.example.assignment02.dto.ItemStatus;
import org.example.assignment02.dto.OrderStatus;
import org.example.assignment02.dto.impl.ItemDTO;
import org.example.assignment02.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrders(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    OrderStatus getOrders(String orderId);
    void deleteOrders(String orderId);
    void updateOrders(String orderId, OrderDTO orderDTO);
}
