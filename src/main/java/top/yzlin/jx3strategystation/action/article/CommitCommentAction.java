package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.Comment;
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.ArticleService;
import top.yzlin.jx3strategystation.service.CommentService;

import java.util.Map;

@Component
public class CommitCommentAction extends ActionSupport implements SessionAware {
    private final ArticleService articleService;
    private final CommentService commentService;
    private Map<String, Object> session;
    private Comment comment;

    public CommitCommentAction(ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String execute() throws Exception {
        comment.setUser((User) session.get("user"));
        comment.setArticle(articleService.findArticleById(comment.getArticle().getArticleId()));
        commentService.saveComment(comment);
        return SUCCESS;
    }


}
