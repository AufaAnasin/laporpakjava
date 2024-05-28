package aptika.example.laporpak.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "tickets")
public class TicketModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ticket_id", unique = true)
    private String ticketId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private int priority;

    @Column(name = "category")
    private String category;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "reported_by")
    private String reportedBy;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "closed_at")
    private LocalDateTime closedAt;

    @OneToMany(mappedBy = "ticket")
    private List<ImageModel> images; // Mapped by the "ticket" field in ImageModel

    @OneToMany(mappedBy = "ticketId")
    private List<CommentModel> comments;
}