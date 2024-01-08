package com.ticket_gen.ticket_generator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@Service
public class TicketGeneratorService {

    public List<Integer> generateTickets(Integer event_id, Integer amount, Integer user_id){
        List<Integer> tickets = new ArrayList<>();

        Stream.iterate(0, n -> n < amount, n -> n+1)
                .forEach(n -> {
                    int randValue = ThreadLocalRandom.current().nextInt(7000, 7000 + event_id + amount);
                    while (tickets.contains(randValue)) {
                        randValue = ThreadLocalRandom.current().nextInt(7000, 7000 + event_id + amount);
                    }
                    tickets.add(randValue);
                });
        return tickets;
    }
}
