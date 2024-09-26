package com.susant.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.*;
 

@Entity
@Table(name="bus_details")
public class BusDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="departure_time")
	private LocalDateTime departureTime;

	@Column(name="capacity")
	private Integer capacity;
	
	@Column(name="number")
	private String number;
	
	@OneToMany(mappedBy="busDetails")
	private Set<Ticket>tickets;
	
	public void addTickets(Ticket ticket) {
		ticket.setBusDetails(this);
		 getTickets().add(ticket);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
	 
}
