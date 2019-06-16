package top.yzlin.jx3strategystation.action.article;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.TradingArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

@Component
public class CommitTradingArticleAction extends BaseCommitArticleAction<TradingArticle> {

    public CommitTradingArticleAction(ArticleService articleService) {
        super(articleService);
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }
}
