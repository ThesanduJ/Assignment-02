package org.example.assignment02.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.assignment02.dto.CustomerStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements CustomerStatus {
    private String phoneNumber;
    private String name;
    private String address;
}
