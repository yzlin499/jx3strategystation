package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.game.MenPai;

import java.util.List;

public interface GameDataDAO {

    @Select("from MenPai")
    List<MenPai> findMenPaiList();

    @Select("select name from MenPai")
    List<String> findMenPaiNameList();
}
