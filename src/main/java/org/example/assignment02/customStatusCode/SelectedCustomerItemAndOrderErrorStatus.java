package org.example.assignment02.customStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.assignment02.dto.CustomerStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomerItemAndOrderErrorStatus implements CustomerStatus {
    private int statusCode;
    private String statusMessage;
}
