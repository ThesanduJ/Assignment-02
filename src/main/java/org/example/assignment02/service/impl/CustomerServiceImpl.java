package org.example.assignment02.service.impl;

import jakarta.transaction.Transactional;
import org.example.assignment02.customStatusCode.SelectedCustomerItemAndOrderErrorStatus;
import org.example.assignment02.dao.CustomerDao;
import org.example.assignment02.dto.CustomerStatus;
import org.example.assignment02.dto.impl.CustomerDTO;
import org.example.assignment02.entity.impl.CustomerEntity;
import org.example.assignment02.exception.CustomerNotFoundException;
import org.example.assignment02.exception.DataPersistException;
import org.example.assignment02.service.CustomerService;
import org.example.assignment02.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private Mapping customerMapping;
    @Override
    public void saveCustomers(CustomerDTO customerDTO) {
        CustomerEntity saveCustomer=customerDao.save(customerMapping.toCustomerEntity(customerDTO));
        if (saveCustomer==null){
            throw new DataPersistException("Note not saved");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerMapping.asCustomerDTOList(customerDao.findAll());
    }

    @Override
    public CustomerStatus getCustomer(String phoneNumber) {
        if (customerDao.existsById(phoneNumber)) {
            var selectedCustomer=customerDao.getReferenceById(phoneNumber);
            return customerMapping.toCustomerDTO(selectedCustomer);
        }else {
            return new SelectedCustomerItemAndOrderErrorStatus(2,"customer not found");
        }
    }

    @Override
    public void deleteCustomer(String phoneNumber) {
        Optional<CustomerEntity> findCustomer=customerDao.findById(phoneNumber);
        if (!findCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDao.deleteById(phoneNumber);
        }
    }

    @Override
    public void updateCustomer(String phoneNumber, CustomerDTO customerDTO) {
        Optional<CustomerEntity> findCustomer=customerDao.findById(phoneNumber);
        if (!findCustomer.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            findCustomer.get().setName(customerDTO.getName());
            findCustomer.get().setAddress(customerDTO.getAddress());
        }
    }
}
