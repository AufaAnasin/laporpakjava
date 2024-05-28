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
@Table(name = "comments")
public class CommentModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "comment_id", unique = true)
    private String commentId;

    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "comment")
    private List<ImageModel> images; // Mapped by the "comment" field in ImageModel
}
