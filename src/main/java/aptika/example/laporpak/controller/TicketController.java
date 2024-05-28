package aptika.example.laporpak.controller;

import aptika.example.laporpak.model.TicketModel;
import aptika.example.laporpak.model.UserModel;
import aptika.example.laporpak.service.TicketService;
import aptika.example.laporpak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class TicketController {
    @Autowired
    private TicketService ticketService;

    // get all ticket
    @GetMapping("tickets")
    public List<TicketModel> getAllTickets() {
        return ticketService.getAllTicketData();
    }
    // get ticket detail by id
    @GetMapping("tickets/{ticketId}")
    public Optional<TicketModel> getTicketById(@PathVariable("ticketId") String ticketId) {
        return ticketService.getTicketById(ticketId);
    }

    // create ticket
    @PostMapping("tickets/create")
    public ResponseEntity<?> createTicket(@RequestBody TicketModel ticket) {
        try {
            TicketModel createTicket = ticketService.createTicket(ticket);
            return ResponseEntity.ok(createTicket);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    // delete ticket
    @DeleteMapping("tickets/{ticketId}/delete")
    public ResponseEntity<Void> deleteTicket(@PathVariable String ticketId) {
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.noContent().build();
    }

 }
