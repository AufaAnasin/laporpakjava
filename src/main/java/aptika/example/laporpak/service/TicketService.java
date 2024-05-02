package aptika.example.laporpak.service;

import aptika.example.laporpak.model.TicketModel;
import aptika.example.laporpak.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<TicketModel> getAllTicketData() {
        List<TicketModel> data = ticketRepository.findAllTickets();
        return data;
    }
}
