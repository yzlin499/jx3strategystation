package top.yzlin.jx3strategystation.action.article;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.TradingArticle;

@Component
public class CommitTradingArticleAction extends BaseCommitArticleAction<TradingArticle> {


    public String getUrl() {
        return "/123456/article/456789";
    }

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

}
