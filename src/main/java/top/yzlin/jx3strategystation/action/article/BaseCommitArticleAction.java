package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;

public class BaseCommitArticleAction<T extends BaseArticle> extends ActionSupport {

    private T article;

    public T getArticle() {
        return article;
    }

    public void setArticle(T article) {
        this.article = article;
    }
}
