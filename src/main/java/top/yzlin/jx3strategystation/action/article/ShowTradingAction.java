package top.yzlin.jx3strategystation.action.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.TradingArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.List;

@Component
public class ShowTradingAction extends BaseShowArticleAction {

    @Autowired
    public ShowTradingAction(ArticleService articleService) {
        super("TradingAction", articleService);
    }

    public List<TradingArticle> getTradingList() {
        return articleService.findTradingArticle();
    }
}
