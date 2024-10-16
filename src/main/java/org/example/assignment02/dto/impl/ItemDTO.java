package org.example.assignment02.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private String itemId;
    private String itemName;
    private String itemDescription;
    private String price;
}
