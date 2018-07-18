package de.aclue.springdatademo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.aclue.springdatademo.persistence.entity.Customer;
import de.aclue.springdatademo.persistence.repository.CustomerRepository;

/**
 *
 * @author Jonas Keßler (jonas.kessler@aclue.de)
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> allCustomers() {
		return customerRepository.findAll();
	}

	public Object currentQuery() {

		// return customerRepository.findAllById(Arrays.asList(1l, 2l, 3l));
		// return customerRepository.countByAge(30);
		// return customerRepository.findById(1l);

		// return customerRepository.findByFirstNameAndLastName("Peter", "Pan");

		return customerRepository.findByOrdersState("New");
	}

	@PostConstruct
	private void storeCustomers() {
		customerRepository.saveAll(createCustomers());
	}

	private List<Customer> createCustomers() {
		List<Customer> entities = new ArrayList<>();
		entities.add(new Customer("Peter", "Pan", 40, "New", "Processed"));
		entities.add(new Customer("Peter", "Meier", 20));
		entities.add(new Customer("Hans", "Schmidt", 30));
		entities.add(new Customer("Hans", "Schmidt", 40));
		entities.add(new Customer("Axel", "Schmidt", 50));
		entities.add(new Customer("Hans", "Müller", 40));
		return entities;
	}
}
