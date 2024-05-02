package aptika.example.laporpak.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "Comments")

public class CommentModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "comment_id", unique = true)
    private String commentId;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketModel ticket;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
    @Column(name = "comment")
    private String comment;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
