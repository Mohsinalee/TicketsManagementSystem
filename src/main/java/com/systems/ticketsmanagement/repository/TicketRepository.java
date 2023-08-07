package com.systems.ticketsmanagement.repository;

import com.systems.ticketsmanagement.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
