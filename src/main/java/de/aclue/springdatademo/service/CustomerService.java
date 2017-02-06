package de.aclue.springdatademo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import de.aclue.springdatademo.persistence.entity.Customer;

/**
 *
 * @author Jonas Keßler (jonas.kessler@aclue.de)
 */
@Service
public class CustomerService {

	public List<Customer> allCustomers() {
		Customer c1 = new Customer("Juergen", "Hoeller", 40);
		Customer c2 = new Customer("Josh", "Long", 41);
		Customer c3 = new Customer("Stephane", "Nicoll", 42);

		return Arrays.asList(c1, c2, c3);
	}

	public List<Customer> currentQuery() {
		Customer c1 = new Customer("Juergen", "Hoeller", 40);
		return Arrays.asList(c1);
	}

	@PostConstruct
	private void storeCustomers() {
		// TODO: persist created customers
		createCustomers();
	}

	private List<Customer> createCustomers() {
		List<Customer> entities = new ArrayList<>();
		entities.add(new Customer("Peter", "Pan", 40));
		entities.add(new Customer("Peter", "Meier", 20));
		entities.add(new Customer("Hans", "Schmidt", 30));
		entities.add(new Customer("Hans", "Schmidt", 40));
		entities.add(new Customer("Axel", "Schmidt", 50));
		entities.add(new Customer("Hans", "Müller", 40));
		return entities;
	}
}
