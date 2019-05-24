package top.yzlin.jx3strategystation.action.admin;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.ReviewArticle;
import top.yzlin.jx3strategystation.service.ReviewArticleService;

import java.util.List;

@Component
public class ShowReviewArticleAction extends ActionSupport {

    private ReviewArticleService reviewArticleService;
//    private List<ReviewArticle> reviewArticleList;

    public ShowReviewArticleAction(ReviewArticleService reviewArticleService) {
        this.reviewArticleService = reviewArticleService;
    }

    public List<ReviewArticle> getReviewArticleList() {
        return reviewArticleService.findReviewArticleList();
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
