package org.example.assignment02.controller;

import org.example.assignment02.customStatusCode.SelectedCustomerItemAndOrderErrorStatus;
import org.example.assignment02.dto.CustomerStatus;
import org.example.assignment02.dto.impl.CustomerDTO;
import org.example.assignment02.exception.CustomerNotFoundException;
import org.example.assignment02.exception.DataPersistException;
import org.example.assignment02.service.CustomerService;
import org.example.assignment02.util.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCustomer(@RequestBody CustomerDTO customerDTO){
        try{
            customerService.saveCustomers(customerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{phoneNumber}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerStatus getSelectedCustomer(@PathVariable("phoneNumber") String phoneNumber){
        if (!Regex.checkPhoneNumber(phoneNumber)){
            return new SelectedCustomerItemAndOrderErrorStatus(1,"Invalid phone number");
        }
        return customerService.getCustomer(phoneNumber);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @DeleteMapping(value = "/{phoneNumber}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("phoneNumber") String phoneNumber){
        try{
            if (!Regex.checkPhoneNumber(phoneNumber)){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.deleteCustomer(phoneNumber);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{phoneNumber}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("phoneNumber") String phoneNumber,@RequestBody CustomerDTO customerDTO){
        try {
            if (!Regex.checkPhoneNumber(phoneNumber)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.updateCustomer(phoneNumber, customerDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (CustomerNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
