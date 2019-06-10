package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.community.ReviewArticle;
import top.yzlin.jx3strategystation.service.ArticleService;
import top.yzlin.jx3strategystation.service.ReviewArticleService;

@Component
public class CommitBanAction extends ActionSupport {
    private final ReviewArticleService reviewArticleService;
    private final ArticleService articleService;
    private int articleId;


    public CommitBanAction(ReviewArticleService reviewArticleService,
                           ArticleService articleService) {
        this.reviewArticleService = reviewArticleService;
        this.articleService = articleService;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Override
    public String execute() throws Exception {
        ReviewArticle reviewArticle = new ReviewArticle();
        BaseArticle articleById = articleService.findArticleById(articleId);
        if (articleById == null) {
            articleId = -1;
            return SUCCESS;
        }
        reviewArticle.setArticle(articleById);
        if (!reviewArticleService.isBanned(articleId)) {
            if (reviewArticleService.saveReviewArticle(reviewArticle) < 1) {
                articleId = -1;
            }
        }
        return SUCCESS;
    }
}
