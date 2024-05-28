package aptika.example.laporpak.repository;

import aptika.example.laporpak.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageModel, String> {
    void deleteByTicket_TicketId(String ticketId);
    List<ImageModel> findByTicket_TicketId(String ticketId);
    List<ImageModel> findByComment_CommentId(String commentId);

}
