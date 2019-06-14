package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.Delete;
import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Save;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.community.ReviewArticle;

import java.util.List;

public interface ReviewArticleDAO {

    @Select("from ReviewArticle")
    List<ReviewArticle> findReviewArticleList();

    @Delete("delete from ReviewArticle where reviewId=:reviewId")
    void deleteReviewArticleById(@QueryParam("reviewId") int id);

    @Save
    int saveReviewArticle(ReviewArticle reviewArticle);

    @Select("select count(*)>0 from ReviewArticle where article.articleId=:articleId")
    boolean isBanned(@QueryParam("articleId") int articleId);

    @Select("select ra.article.articleId from ReviewArticle ra where reviewId=:reviewId")
    int findArticleIdByReviewId(@QueryParam("reviewId") int id);
}
