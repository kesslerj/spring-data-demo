package de.aclue.springdatademo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.aclue.springdatademo.persistence.entity.Customer;
import de.aclue.springdatademo.persistence.repository.CustomerRepository;

/**
 *
 * @author Jonas Keßler (jonas.kessler@aclue.de)
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	/*
	 * Automatic conversion of pathvariable 'id' to Customer object
	 *  -> no explicit repository call needed here
	 */
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") Customer c) {
		return c;
	}

	/*
	 * Requestparameters are used to instantiate Pageable (Sort possible as well) object
	 * -> page, size, sort
	 */
	@GetMapping
	public Page<Customer> getCustomers(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}
}
