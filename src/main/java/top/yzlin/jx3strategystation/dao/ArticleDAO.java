package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Save;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;

public interface ArticleDAO {

    @Save
    void saveArticle(BaseArticle baseArticle);

    @Select("from BaseArticle a where a.id=:id")
    BaseArticle findArticleById(@QueryParam("id") int id);
}
