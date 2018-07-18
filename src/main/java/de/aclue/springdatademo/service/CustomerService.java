package de.aclue.springdatademo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.aclue.springdatademo.persistence.entity.Customer;
import de.aclue.springdatademo.persistence.repository.CustomerRepository;
import de.aclue.springdatademo.persistence.repository.projection.CustomerNameProjection;

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

		// return customerRepository.findByOrdersState("New");
		// return customerRepository.findByOrders_State("New");

		// return customerRepository.findAllFirstNames().toString();

		return projections();
	}

	private Object projections() {
		List<CustomerNameProjection> projections = new ArrayList<>();

		return projections
				.stream()
				.map(p -> p.getFirstName() + " " + p.getLastName())
				.collect(Collectors.toList());
	}

	@PostConstruct
	private void storeCustomers() {
		customerRepository.saveAll(createCustomers());
	}

	private List<Customer> createCustomers() {
		List<Customer> entities = new ArrayList<>();
		entities.add(new Customer("Peter", "Pan", 40, "New", "Processed"));
		entities.add(new Customer("Peter", "Meier", 20, "Process", "New"));
		entities.add(new Customer("Hans", "Schmidt", 30));
		entities.add(new Customer("Hans", "Schmidt", 40));
		entities.add(new Customer("Axel", "Schmidt", 50));
		entities.add(new Customer("Hans", "Müller", 40));
		return entities;
	}
}
