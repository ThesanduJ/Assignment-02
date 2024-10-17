package org.example.assignment02.dao;

import org.example.assignment02.entity.impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends JpaRepository<OrderEntity,String> {
}
