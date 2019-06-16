package top.yzlin.jx3strategystation.action.article;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.CommonArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

@Component
public class CommitCommonArticleAction extends BaseCommitArticleAction<CommonArticle> {

    public CommitCommonArticleAction(ArticleService articleService) {
        super(articleService);
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }
}