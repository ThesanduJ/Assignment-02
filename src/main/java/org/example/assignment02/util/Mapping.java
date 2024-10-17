package org.example.assignment02.util;

import org.example.assignment02.dto.impl.CustomerDTO;
import org.example.assignment02.dto.impl.ItemDTO;
import org.example.assignment02.dto.impl.OrderDTO;
import org.example.assignment02.entity.impl.CustomerEntity;
import org.example.assignment02.entity.impl.ItemEntity;
import org.example.assignment02.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    //for customer
    @Autowired
    private ModelMapper modelMapper;

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }

    public List<CustomerDTO> asCustomerDTOList(List<CustomerEntity> customerEntityList) {
        return modelMapper.map(customerEntityList, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    //for item

    public ItemDTO toItemDTO(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }

    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }

    public List<ItemDTO> asItemDTOList(List<ItemEntity> itemEntityList) {
        return modelMapper.map(itemEntityList, new TypeToken<List<ItemDTO>>() {

        }.getType());
    }

    //for orders

    public OrderDTO toOrderDTO(OrderEntity orderEntity) {
        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    public OrderEntity toOrderEntity(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderEntity.class);
    }

    public List<OrderDTO> asOrderDTOList(List<OrderEntity> orderEntityList) {
        return modelMapper.map(orderEntityList, new TypeToken<List<OrderDTO>>() {

        }.getType());
    }
}
