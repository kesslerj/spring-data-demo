package de.aclue.springdatademo.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Jonas Keßler (jonas.kessler@acando.de)
 */
@Entity
@Table(name = "T_ORDER")
public class Order {

	private Long id;
	private Customer customer;
	private int amount;
	private String state;

	public Order() {
	}

	public Order(Customer customer, String state) {
		this.customer = customer;
		this.state = state;
	}

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	@Column(name = "AMOUNT")
	public int getAmount() {
		return amount;
	}

	@Column(name = "STATE")
	public String getState() {
		return state;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
