package top.yzlin.jx3strategystation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yzlin.jx3strategystation.dao.CommentDAO;
import top.yzlin.jx3strategystation.entity.community.Comment;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentService {
    private final CommentDAO commentDAO;


    public CommentService(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    public void saveComment(Comment comment) {
        commentDAO.saveComment(comment);
    }
}
