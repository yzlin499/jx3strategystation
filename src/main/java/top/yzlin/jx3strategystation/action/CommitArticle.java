package top.yzlin.jx3strategystation.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;

import java.util.Map;

public class CommitArticle extends ActionSupport implements SessionAware {
    private BaseArticle article;
    private Map<String, Object> session;

    public BaseArticle getArticle() {
        return article;
    }

    public void setArticle(BaseArticle article) {
        this.article = article;
    }

    public String getUrl() {
        return "/123456/article/456789";
    }

    @Override
    public String execute() throws Exception {
        session.put("article", article);
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
