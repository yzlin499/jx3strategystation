package top.yzlin.jx3strategystation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yzlin.jx3strategystation.dao.ReviewArticleDAO;
import top.yzlin.jx3strategystation.entity.community.ReviewArticle;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ReviewArticleService {

    private final ReviewArticleDAO reviewArticleDAO;

    @Autowired
    public ReviewArticleService(ReviewArticleDAO reviewArticleDAO) {
        this.reviewArticleDAO = reviewArticleDAO;
    }

    public List<ReviewArticle> findReviewArticleList() {
        return reviewArticleDAO.findReviewArticleList();
    }

    public void deleteReviewArticleById(int id) {
        reviewArticleDAO.deleteReviewArticleById(id);
    }
}
