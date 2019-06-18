package top.yzlin.jx3strategystation.action.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.CommonArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.List;

@Component
public class ShowCommonAction extends BaseShowArticleAction {

    @Autowired
    public ShowCommonAction(ArticleService articleService) {
        super("CommonAction", articleService);
    }

    public List<CommonArticle> getCommonArticle() {
        return articleService.findCommonArticle();
    }

}
