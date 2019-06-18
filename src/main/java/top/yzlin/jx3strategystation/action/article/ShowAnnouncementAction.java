package top.yzlin.jx3strategystation.action.article;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.AnnouncementArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.List;
import java.util.Optional;

@Component
public class ShowAnnouncementAction extends BaseShowArticleAction {

    public String instance;
    public List<AnnouncementArticle> announcementArticleList;

    public ShowAnnouncementAction(ArticleService articleService) {
        super("Announcement", articleService);
    }

    public String getInstance() {
        return Optional.ofNullable(instance).orElse("最新");
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public List<AnnouncementArticle> getAnnouncementArticleList() {
        return announcementArticleList;
    }

    @Override
    public String execute() throws Exception {
        announcementArticleList = articleService.findAnnouncementArticleByInstance(getInstance());
        return super.execute();
    }
}
