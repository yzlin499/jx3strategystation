package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.Map;


public class BaseCommitArticleAction<T extends BaseArticle> extends ActionSupport implements SessionAware {
    private ArticleService articleService;
    private Map<String, Object> session;
    private T article;
    private int articleId;

    public BaseCommitArticleAction(ArticleService articleService) {
        this.articleService = articleService;
    }

    public T getArticle() {
        return article;
    }

    public void setArticle(T article) {
        this.article = article;
    }

    public String getUrl() {
        return "/" + ((User) session.get("user")).getUserName() + "/article/" + articleId;
    }

    @Override
    public String execute() {
        article.setUser((User) session.get("user"));
        articleId = articleService.saveArticle(article);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
