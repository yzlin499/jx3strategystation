package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.Save;
import top.yzlin.jx3strategystation.entity.community.Comment;

public interface CommentDAO {

    @Save
    int saveComment(Comment comment);
}
