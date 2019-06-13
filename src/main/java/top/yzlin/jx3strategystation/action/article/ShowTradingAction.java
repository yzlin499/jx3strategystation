package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.TradingArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.List;

@Component
public class ShowTradingAction extends ActionSupport {
    private final ArticleService articleService;

    @Autowired
    public ShowTradingAction(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<TradingArticle> getTradingList() {
        return articleService.findTradingArticle();
    }

    @Override
    public String execute() {
        return SUCCESS;
    }
}
