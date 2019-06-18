package top.yzlin.jx3strategystation.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.List;
import java.util.Map;

@Component
public class UserPersonalHomepageAction extends ActionSupport implements SessionAware {

    private final ArticleService articleService;
    private Map<String, Object> session;

    public UserPersonalHomepageAction(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<BaseArticle> getArticleList() {
        return articleService.findArticleByUserId(((User) session.get("user")).getUserId());
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
