package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Save;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;

public interface ArticleDAO {

    @Save
    int saveArticle(BaseArticle baseArticle);

    @Select("from BaseArticle where articleId=:articleId and user.userName=:userName")
    BaseArticle findArticleByIdAndUserName(@QueryParam("articleId") int articleId,
                                           @QueryParam("userName") String userName);

    @Select("from BaseArticle where articleId=:articleId")
    BaseArticle findArticleById(@QueryParam("articleId") int id);
}
