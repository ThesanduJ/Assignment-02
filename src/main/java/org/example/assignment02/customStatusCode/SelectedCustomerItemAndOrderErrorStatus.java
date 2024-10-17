package org.example.assignment02.customStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.assignment02.dto.CustomerStatus;
import org.example.assignment02.dto.ItemStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomerItemAndOrderErrorStatus implements CustomerStatus, ItemStatus {
    private int statusCode;
    private String statusMessage;
}
