package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.community.Comment;
import top.yzlin.jx3strategystation.service.ArticleService;
import top.yzlin.jx3strategystation.service.CommentService;

import java.util.List;

@Component
public class ShowArticle extends ActionSupport {
    private int articleId;
    private String userName;
    private BaseArticle article;
    private ArticleService articleService;
    private CommentService commentService;

    public BaseArticle getArticle() {
        return article;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        try {
            this.articleId = Integer.parseInt(articleId);
        } catch (NumberFormatException e) {
            this.articleId = -1;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Comment> getCommentList() {
        return commentService.findCommentByArticleId(articleId);
    }

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public String execute() throws Exception {
        article = articleService.findArticleByIdAndUserName(articleId, userName);
        return article == null ? ERROR : SUCCESS;
    }
}
