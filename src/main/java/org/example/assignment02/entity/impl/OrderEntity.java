package org.example.assignment02.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.assignment02.entity.SuperEntity;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity {
    @Id
    private String orderId;
    @Column(nullable = false)
    private String customerNumber;
    @Column(nullable = false)
    private Date orderDate;
    @Column(nullable = false)
    private double totalPrice;
}
