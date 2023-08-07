package com.systems.ticketsmanagement.controller;

import com.systems.ticketsmanagement.entity.Ticket;
import com.systems.ticketsmanagement.repository.TicketRepository;
import com.systems.ticketsmanagement.dto.TicketStatusUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @PutMapping("/{ticketId}/status")
    public ResponseEntity<String> updateTicketStatus(@PathVariable Long ticketId, @RequestBody TicketStatusUpdateRequestDTO request) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setStatus(request.getStatus());
            ticket.setTechnicalFeedback(request.getTechnicalFeedback());
            ticketRepository.save(ticket);
            return ResponseEntity.ok("Ticket status updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
