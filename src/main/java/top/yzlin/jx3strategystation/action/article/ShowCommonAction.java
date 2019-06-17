package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.CommonArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.List;

@Component
public class ShowCommonAction extends ActionSupport {
    private final ArticleService articleService;
    private String ActionName = "CommonAction";

    @Autowired
    public ShowCommonAction(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<CommonArticle> getCommonArticle() {
        return articleService.findCommonArticle();
    }

    public String getCActionName() {
        return ActionName;
    }

    public String execute() {
        return SUCCESS;
    }
}
