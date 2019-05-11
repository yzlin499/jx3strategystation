package top.yzlin.jx3strategystation.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

@Component
public class ShowArticle extends ActionSupport {
    private int articleId;
    private String userName;
    private BaseArticle article;
    private ArticleService articleService;

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
