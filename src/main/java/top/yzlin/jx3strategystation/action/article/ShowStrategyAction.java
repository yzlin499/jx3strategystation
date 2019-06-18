package top.yzlin.jx3strategystation.action.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.StrategyArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.List;

@Component
public class ShowStrategyAction extends BaseShowArticleAction {

    @Autowired
    public ShowStrategyAction(ArticleService articleService) {
        super("StrategyAction", articleService);
    }

    public List<StrategyArticle> getStrategyList() {
        return articleService.findStrategyArticle();
    }

}
