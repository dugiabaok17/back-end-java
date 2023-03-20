package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdCustomerService;
import com.example.demo.entity.Color;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ICustomerService implements AdCustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public ICustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll().stream().filter(data -> data.getStatus() == 1).toList();
    }

    @Override
    public ResponseEntity<ResponseObject> findByCustomer(Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        return foundCustomer.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "found Customer with id: " + id, 0, foundCustomer)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("fail", "not found Customer with id: " + id, 0, foundCustomer)
        );
    }

    @Override
    public ResponseEntity<ResponseObject> createCustomer(Customer customer) {
        Customer c = new Customer();
        c.setDateCreated(new Date(System.currentTimeMillis()));
        c.setAddress(customer.getAddress());
        c.setCity(customer.getCity());
        c.setEmail(customer.getEmail());
        c.setDateOfBirth(customer.getDateOfBirth());
        c.setFirstName(customer.getFirstName());
        c.setGender(customer.getGender());
        c.setMiddleName(customer.getMiddleName());
        c.setNation(customer.getNation());
        c.setSurname(customer.getSurname());
        c.setPassword(customer.getPassword());
        c.setPhoneNumber(customer.getPhoneNumber());
        c.setStatus(1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","insert customer success",0,customerRepository.save(c))
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateCustomer(Customer customer, Long id) {
        Optional<Customer> c = customerRepository.findById(id);
        if (c.isPresent()) {
            c.get().setDateUpdated(new Date(System.currentTimeMillis()));
            c.get().setAddress(customer.getAddress());
            c.get().setCity(customer.getCity());
            c.get().setDateOfBirth(customer.getDateOfBirth());
            c.get().setFirstName(customer.getFirstName());
            c.get().setGender(customer.getGender());
            c.get().setMiddleName(customer.getMiddleName());
            c.get().setNation(customer.getNation());
            c.get().setSurname(customer.getSurname());
            c.get().setPassword(customer.getPassword());
            c.get().setPhoneNumber(customer.getPhoneNumber());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "update successfully", 0, customerRepository.save(c.get())));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("fail", "Can not update color ", 1, ""));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteCustomer(Long id) {
        boolean exists = customerRepository.existsById(id);
        if (exists) {
            customerRepository.updateStatus(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete customer successfully", 0, "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find customer to delete", -1, ""));
    }
}
