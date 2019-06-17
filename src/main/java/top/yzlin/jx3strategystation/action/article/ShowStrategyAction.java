package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.StrategyArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.List;

@Component
public class ShowStrategyAction extends ActionSupport {
    private String Actionname = "StrageAction";
    private final ArticleService articleService;

    @Autowired
    public ShowStrategyAction(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<StrategyArticle> getStrategyList() {
        return articleService.findStrategyArticle();
    }

    public String getSActionname() {
        return Actionname;
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
}
