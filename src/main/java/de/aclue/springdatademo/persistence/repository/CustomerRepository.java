package de.aclue.springdatademo.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.aclue.springdatademo.persistence.entity.Customer;
import de.aclue.springdatademo.persistence.repository.projection.CustomerNameProjection;

/**
 *
 * @author Jonas Keßler (jonas.kessler@acando.de)
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	// List<Customer> findByFirstNameAndLastName(String first, String last);
	// Customer findByFirstNameAndLastName(String first, String last);
	Optional<Customer> findByFirstNameAndLastName(String first, String last);

	int countByAge(int age);

	// searches for customer.ordersState =
	List<Customer> findByOrdersState(String ordersState);

	List<Customer> findDistinctByOrdersState(String ordersState);

	// searches for customer.orders.state =
	List<Customer> findByOrders_State(String state);

	@Query("SELECT c.firstName FROM Customer c")
	List<String> findAllFirstNames();

	/*
	 * Projections
	 */
	// this works like findAll
	List<CustomerNameProjection> findProjectionsBy();
	
	List<CustomerNameProjection> findDistinctProjectionsBy();

	// same query can be formulated for entity and projection
	// (there is no need to use Projection keyword in query)
	List<Customer> findByAgeLessThan(int maxAge);
	List<CustomerNameProjection> findProjectionsByAgeLessThan(int maxAge);

}
