package com.ivanjohn.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivanjohn.myproject.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
