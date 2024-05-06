package aptika.example.laporpak.repository;

import aptika.example.laporpak.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentModel, Integer> {
    @Query(value = "SELECT c FROM CommentModel c WHERE c.ticketId = :ticketId")
    List<CommentModel> findCommentsByTicketId(String ticketId);
}
