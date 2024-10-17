package org.example.assignment02.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.assignment02.entity.SuperEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "items")
public class ItemEntity implements SuperEntity {
    @Id
    private String itemId;
    @Column(nullable = false)
    private String itemName;
    private String itemDescription;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String quantity;
}
