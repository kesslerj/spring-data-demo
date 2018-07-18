package de.aclue.springdatademo.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.aclue.springdatademo.persistence.entity.Customer;

/**
 *
 * @author Jonas Keßler (jonas.kessler@aclue.de)
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// List<Customer> findByFirstNameAndLastName(String first, String last);
	// Customer findByFirstNameAndLastName(String first, String last);
	Optional<Customer> findByFirstNameAndLastName(String first, String last);

	int countByAge(int age);


}
