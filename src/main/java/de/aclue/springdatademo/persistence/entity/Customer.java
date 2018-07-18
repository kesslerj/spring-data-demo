package de.aclue.springdatademo.persistence.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {

	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;
	private List<Order> orders = new ArrayList<>();
	private String ordersState;

	public Customer() {
	}

	public Customer(String firstName, String lastName, Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Customer(String firstName, String lastName, Integer age, String ordersState, String... orderStates) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.ordersState = ordersState;
		Stream.of(orderStates).forEach(s -> this.getOrders().add(new Order(this, s)));
	}

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return age;
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	public List<Order> getOrders() {
		return orders;
	}

	@Column(name = "ORDERSSTATE")
	public String getOrdersState() {
		return ordersState;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setOrdersState(String ordersState) {
		this.ordersState = ordersState;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

}
