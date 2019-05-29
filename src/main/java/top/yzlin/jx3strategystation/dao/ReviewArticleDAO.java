package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.Delete;
import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.community.ReviewArticle;

import java.util.List;

public interface ReviewArticleDAO {

    @Select("from ReviewArticle")
    List<ReviewArticle> findReviewArticleList();

    @Delete("delete from ReviewArticle where reviewId=:reviewId")
    void deleteReviewArticleById(@QueryParam("reviewId") int id);
}
