package com.example.springsecuritydemoapp.repository;

import com.example.springsecuritydemoapp.modal.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
List<Customer> findByEmail(String email);
}
