package com.ivanjohn.myproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ivanjohn.myproject.entity.Customer;
import com.ivanjohn.myproject.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping(path="/customers", produces="application/json")
	public List<Customer> getCustomer() {
		return customerRepository.findAll();
	}
	
	@GetMapping(path="/customer/{id}", produces="application/json")
	public Optional<Customer> getCustomer(@PathVariable int id) {
		return customerRepository.findById(id);
	}
	
	@PostMapping(path="/customer", consumes="application/json")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return customer;
	}
	
	@DeleteMapping(path="/customer/{id}", consumes="application/json")
	public Optional<Customer> deleteCustomer(@PathVariable int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		customerRepository.deleteById(id);
		return customer;
	}
	
	@PutMapping(path="customer", consumes="application/json")
	public Customer updateOrSaveCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return customer;
	}
	
}
