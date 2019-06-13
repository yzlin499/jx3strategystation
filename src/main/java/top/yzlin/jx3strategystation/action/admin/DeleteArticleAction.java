package top.yzlin.jx3strategystation.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.service.ArticleService;
import top.yzlin.jx3strategystation.service.ReviewArticleService;


@Component
public class DeleteArticleAction extends ActionSupport {
    private int reviewId;
    private final ReviewArticleService reviewArticleService;
    private final ArticleService articleService;

    @Autowired
    public DeleteArticleAction(ReviewArticleService reviewArticleService, ArticleService articleService) {
        this.reviewArticleService = reviewArticleService;
        this.articleService = articleService;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String execute() throws Exception {
        int aId = reviewArticleService.findArticleIdByReviewId(reviewId);
        reviewArticleService.deleteReviewArticleById(reviewId);
        articleService.deleteArticleById(aId);
        return SUCCESS;
    }
}
