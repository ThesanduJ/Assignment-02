package org.example.assignment02.customStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.assignment02.dto.CustomerStatus;
import org.example.assignment02.dto.ItemStatus;
import org.example.assignment02.dto.OrderStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomerItemAndOrderErrorStatus implements CustomerStatus, ItemStatus, OrderStatus {
    private int statusCode;
    private String statusMessage;
}
