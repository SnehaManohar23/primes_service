package com.example.primesservice.repository;

import com.example.primesservice.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface AuthenticationDBRepository extends CrudRepository<Customer, String>{
    Customer findByUsername(String username);
}
