package com.susant.entity;

import jakarta.persistence.*;
@Entity
@Table(name="ticket_details")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name")
	private  String firstName;

	@Column(name="last_name")
	private  String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="bus_Id")
	private BusDetails busDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BusDetails getBusDetails() {
		return busDetails;
	}

	public void setBusDetails(BusDetails busDetails) {
		this.busDetails = busDetails;
	}
	
	

}
