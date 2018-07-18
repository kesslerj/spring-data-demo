package de.aclue.springdatademo.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.aclue.springdatademo.persistence.entity.Customer;

/**
 *
 * @author Jonas Keßler (jonas.kessler@acando.de)
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// List<Customer> findByFirstNameAndLastName(String first, String last);
	// Customer findByFirstNameAndLastName(String first, String last);
	Optional<Customer> findByFirstNameAndLastName(String first, String last);

	int countByAge(int age);

	List<Customer> findByOrdersState(String ordersState);

	List<Customer> findDistinctByOrdersState(String ordersState);

}
