package com.susant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.susant.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
