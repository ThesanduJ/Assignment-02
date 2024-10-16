package org.example.assignment02.service;

import org.example.assignment02.dto.CustomerStatus;
import org.example.assignment02.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomers(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerStatus getCustomer(String phoneNumber);
    void deleteCustomer(int phoneNumber);
    void updateCustomer(int phoneNumber, CustomerDTO customerDTO);
}
