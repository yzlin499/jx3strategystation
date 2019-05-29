package top.yzlin.jx3strategystation.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.service.ReviewArticleService;

@Component
public class PassArticleAction extends ActionSupport {

    private final ReviewArticleService reviewArticleService;

    private int reviewId;

    @Autowired
    public PassArticleAction(ReviewArticleService reviewArticleService) {
        this.reviewArticleService = reviewArticleService;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String execute() throws Exception {
        reviewArticleService.deleteReviewArticleById(reviewId);
        return SUCCESS;
    }
}
