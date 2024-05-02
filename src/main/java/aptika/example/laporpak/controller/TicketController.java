package aptika.example.laporpak.controller;

import aptika.example.laporpak.model.TicketModel;
import aptika.example.laporpak.service.TicketService;
import aptika.example.laporpak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("tickets")
    public List<TicketModel> getAllTickets() {
        return ticketService.getAllTicketData();
    }
}
