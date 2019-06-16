package top.yzlin.jx3strategystation.action.article;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.StrategyArticle;
import top.yzlin.jx3strategystation.service.ArticleService;


@Component
public class CommitStrategyArticleAction extends BaseCommitArticleAction<StrategyArticle> {
    public CommitStrategyArticleAction(ArticleService articleService) {
        super(articleService);
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }
}