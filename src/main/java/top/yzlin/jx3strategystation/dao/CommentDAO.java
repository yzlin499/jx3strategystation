package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Save;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.community.Comment;

import java.util.List;

public interface CommentDAO {

    @Select("from Comment where article.articleId=:articleId")
    List<Comment> findCommentByArticleId(@QueryParam("articleId") int articleId);

    @Save
    int saveComment(Comment comment);
}
