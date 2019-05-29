package top.yzlin.jx3strategystation.action.article;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.TradingArticle;
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.Map;

@Component
public class CommitTradingArticleAction extends BaseCommitArticleAction<TradingArticle> implements SessionAware {

    private ArticleService articleService;
    private Map<String, Object> session;
    private int articleId;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public String getUrl() {
        return "/" + ((User) session.get("user")).getUserName() + "/article/" + articleId;
    }

    @Override
    public String execute() throws Exception {
        TradingArticle article = getArticle();
        article.setUser((User) session.get("user"));
        articleId = articleService.saveArticle(getArticle());
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
