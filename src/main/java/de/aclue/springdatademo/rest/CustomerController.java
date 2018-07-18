package de.aclue.springdatademo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.aclue.springdatademo.persistence.entity.Customer;

/**
 *
 * @author Jonas Keßler (jonas.kessler@aclue.de)
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") Customer c) {
		return c;
	}

}
