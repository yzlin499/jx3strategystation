package top.yzlin.jx3strategystation.action.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.TradingArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

@Component
public class CommitTradingArticleAction extends BaseCommitArticleAction<TradingArticle> {

    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public String getUrl() {
        return "/123456/article/456789";
    }

    @Override
    public String execute() throws Exception {
        articleService.saveArticle(getArticle());
        return SUCCESS;
    }

}
