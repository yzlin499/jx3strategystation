package top.yzlin.jx3strategystation.action.article;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.AnnouncementArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

@Component
public class CommitAnnouncementArticleAction extends BaseCommitArticleAction<AnnouncementArticle> {

    public CommitAnnouncementArticleAction(ArticleService articleService) {
        super(articleService);
    }

    @Override
    public String getUrl() {
        return super.getUrl();
    }
}