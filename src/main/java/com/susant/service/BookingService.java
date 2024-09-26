package com.susant.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.susant.entity.BusDetails;
import com.susant.entity.Ticket;
import com.susant.repository.BusRepository;
import com.susant.repository.TicketRepository;

@Service
public class BookingService {

	@Autowired
	private BusRepository busRepository;

	@Autowired
	private TicketRepository ticketRepository;

	public void saveTickets(String firstName,String lastName,String gender,BusDetails busDetails) {
		if(busDetails.getCapacity()<=busDetails.getTickets().size()) {
			throw new RuntimeException("Seat Not Available..");
		}
		Ticket ticket=new Ticket();
		ticket.setFirstName(firstName);
		ticket.setLastName(lastName);
		ticket.setGender(gender);
		busDetails.addTickets(ticket);
		ticketRepository.save(ticket);
	}

	public void bookTickets() throws Exception{
		Optional<BusDetails> busIds = busRepository.findById(1L);
		if (busIds.isPresent()) {
			saveTickets("susanta","nahak","Male",busIds.get());
		}
		Thread.sleep(1000);
	}
	public void bookTickets1() throws Exception{
		Optional<BusDetails> busIds = busRepository.findById(1L);
		if (busIds.isPresent()) {
			saveTickets("durga","nahak","Female",busIds.get());
		}
		Thread.sleep(1000);
	}
}
