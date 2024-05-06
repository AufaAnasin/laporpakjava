package aptika.example.laporpak.controller;

import aptika.example.laporpak.model.CommentModel;
import aptika.example.laporpak.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")

public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("tickets/{ticketId}/comments")
    public List<CommentModel> fetchCommentByTicketId(@PathVariable("ticketId") String ticketId) {
        return commentService.getCommentByTicketId(ticketId);
    }

    @PostMapping("tickets/{ticketId}/comments")
    public ResponseEntity<CommentModel> createComment(@PathVariable("ticketId") String ticketId, @RequestBody CommentModel comment) {
        comment.setTicketId(ticketId);
        comment.setCreatedAt(LocalDateTime.now());
        CommentModel createComment = commentService.createComment(comment);
        return new ResponseEntity<>(createComment, HttpStatus.CREATED);
    }
}
