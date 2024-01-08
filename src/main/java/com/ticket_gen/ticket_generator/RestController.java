package com.ticket_gen.ticket_generator;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final TicketGeneratorService ticketGeneratorService;

    public RestController(TicketGeneratorService ticketGeneratorService) {
        this.ticketGeneratorService = ticketGeneratorService;
    }

    @GetMapping("/gen")
    public List<Integer> getTickets(Integer event_id, Integer amount, Integer user_id){
        return ticketGeneratorService.generateTickets(event_id, amount, user_id);
    }
}
