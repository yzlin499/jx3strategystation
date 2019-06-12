package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.OperateQuery;
import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Save;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.community.StrategyArticle;
import top.yzlin.jx3strategystation.entity.community.TradingArticle;

import java.util.List;

public interface ArticleDAO {

    @Save
    int saveArticle(BaseArticle baseArticle);

    @Select("from BaseArticle where articleId=:articleId and user.userName=:userName")
    BaseArticle findArticleByIdAndUserName(@QueryParam("articleId") int articleId,
                                           @QueryParam("userName") String userName);

    @Select("from BaseArticle where articleId=:articleId")
    BaseArticle findArticleById(@QueryParam("articleId") int id);

    default List<BaseArticle> findArticle(int page) {
        return findArticle(q -> q.setFirstResult((page < 0 ? 0 : page) * 15).setMaxResults(15));
    }

    @Select("from BaseArticle")
    List<BaseArticle> findArticle(OperateQuery operateQuery);

    @Select("from StrategyArticle")
    List<StrategyArticle> findStrategyArticle();

    @Select("from TradingArticle")
    List<TradingArticle> findTradingArticle();
}
