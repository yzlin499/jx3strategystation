package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.game.QiXueGroup;

import java.util.List;

public interface QiXueGroupDAO {

    @Select("from QiXueGroup")
    List<QiXueGroup> findQiXueGroup();
}
