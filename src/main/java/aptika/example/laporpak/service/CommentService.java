package aptika.example.laporpak.service;

import aptika.example.laporpak.model.CommentModel;
import aptika.example.laporpak.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<CommentModel> getCommentByTicketId(String ticketId) {
        List<CommentModel> data = commentRepository.findCommentsByTicketId(ticketId);
        return data;
    }

    // add comment
    public CommentModel createComment(CommentModel comment) {
        return commentRepository.save(comment);
    }
}
