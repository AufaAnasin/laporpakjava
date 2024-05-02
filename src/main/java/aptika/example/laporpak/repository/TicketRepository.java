package aptika.example.laporpak.repository;

import aptika.example.laporpak.model.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketModel, Integer> {

    @Query(value = "SELECT * FROM tickets", nativeQuery = true)
    List<TicketModel> findAllTickets();

}
