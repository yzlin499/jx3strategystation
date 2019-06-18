package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import top.yzlin.jx3strategystation.service.ArticleService;

public abstract class BaseShowArticleAction extends ActionSupport {
    final ArticleService articleService;
    private String actionName;

    public BaseShowArticleAction(String actionName, ArticleService articleService) {
        this.actionName = actionName;
        this.articleService = articleService;
    }

    public String getActionName() {
        return actionName;
    }

}
