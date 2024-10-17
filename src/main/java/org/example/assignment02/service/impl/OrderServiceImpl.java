package org.example.assignment02.service.impl;

import org.example.assignment02.customStatusCode.SelectedCustomerItemAndOrderErrorStatus;
import org.example.assignment02.dao.ItemDao;
import org.example.assignment02.dao.OrdersDao;
import org.example.assignment02.dto.OrderStatus;
import org.example.assignment02.dto.impl.OrderDTO;
import org.example.assignment02.entity.impl.OrderEntity;
import org.example.assignment02.exception.DataPersistException;
import org.example.assignment02.exception.OrderNotFoundException;
import org.example.assignment02.service.OrderService;
import org.example.assignment02.util.AppUtil;
import org.example.assignment02.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersDao orderDao;
    @Autowired
    private Mapping orderMapping;

    @Override
    public void saveOrders(OrderDTO orderDTO) {
        orderDTO.setOrderId(AppUtil.generateOrderID());
        orderDTO.setOrderDate(new Date());
        OrderEntity saveOrder = orderDao.save(orderMapping.toOrderEntity(orderDTO));
        if (saveOrder == null) {
            throw new DataPersistException("Order not saved");
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderMapping.asOrderDTOList(orderDao.findAll());
    }

    @Override
    public OrderStatus getOrders(String orderId) {
        if (orderDao.existsById(orderId)) {
            var selectedOrder=orderDao.getReferenceById(orderId);
            return orderMapping.toOrderDTO(selectedOrder);
        }else {
            return new SelectedCustomerItemAndOrderErrorStatus(2,"Selected order is not found");
        }
    }

    @Override
    public void deleteOrders(String orderId) {
        Optional<OrderEntity> findOrder = orderDao.findById(orderId);
        if (!findOrder.isPresent()) {
            throw new OrderNotFoundException("Order not deleted");
        }else {
            orderDao.deleteById(orderId);
        }
    }

    @Override
    public void updateOrders(String orderId, OrderDTO orderDTO) {
        Optional<OrderEntity> findOrder = orderDao.findById(orderId);
        if (!findOrder.isPresent()) {
            throw new OrderNotFoundException("Order not found");
        }else {
            findOrder.get().setTotalPrice(orderDTO.getTotalPrice());
            findOrder.get().setCustomerNumber(orderDTO.getCustomerNumber());
        }
    }
}
