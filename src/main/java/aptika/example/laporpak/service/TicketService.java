package aptika.example.laporpak.service;

import aptika.example.laporpak.model.TicketModel;
import aptika.example.laporpak.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    LocalDateTime currentTime = LocalDateTime.now();

    public List<TicketModel> getAllTicketData() {
        List<TicketModel> data = ticketRepository.findAllTickets();
        return data;
    }

    // find ticket by id
    public Optional<TicketModel> getTicketById(String ticketId) {
        Optional<TicketModel> data = ticketRepository.findTicketById(ticketId);
        return data;
    }

    // create ticket
    public TicketModel createTicket(TicketModel ticket) {
        ticket.setCreatedAt(currentTime);
        ticket.setUpdatedAt(currentTime);
        return ticketRepository.save(ticket);
    }
}
