package top.yzlin.jx3strategystation.action.admin;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.ReviewArticle;
import top.yzlin.jx3strategystation.service.ReviewArticleService;

import java.util.List;

@Component
public class ShowReviewArticleAction extends BaseAdminAction {

    private ReviewArticleService reviewArticleService;
//    private List<ReviewArticle> reviewArticleList;

    public ShowReviewArticleAction(ReviewArticleService reviewArticleService) {
        this.reviewArticleService = reviewArticleService;
    }

    public List<ReviewArticle> getReviewArticleList() {
        return reviewArticleService.findReviewArticleList();
    }
}
