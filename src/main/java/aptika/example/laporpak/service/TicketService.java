package aptika.example.laporpak.service;

import aptika.example.laporpak.model.TicketModel;
import aptika.example.laporpak.repository.CommentRepository;
import aptika.example.laporpak.repository.ImageRepository;
import aptika.example.laporpak.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private CommentRepository commentRepository;
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

    // delete ticket
    public void deleteTicket(String ticketId) {
        commentRepository.findCommentsByTicketId(ticketId).forEach(comment -> {
            imageRepository.deleteAll(imageRepository.findByComment_CommentId(comment.getCommentId()));
            commentRepository.delete(comment);
        });
        // delete the image that asosociated witht ticket
        imageRepository.deleteByTicket_TicketId(ticketId);
        // delete the ticket
        ticketRepository.deleteById(ticketId);
    }
}
