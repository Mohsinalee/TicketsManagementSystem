package com.systems.ticketsmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketStatusUpdateRequestDTO {
    private String status;
    private String technicalFeedback;
}
