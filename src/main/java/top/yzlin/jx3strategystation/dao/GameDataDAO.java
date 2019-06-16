package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.game.MenPai;
import top.yzlin.jx3strategystation.entity.game.XinFa;

import java.util.List;
import java.util.stream.Collectors;

public interface GameDataDAO {

    @Select("select mp.xinFas from MenPai mp,XinFa xf where xf.name=:xinFaName and xf in elements(mp.xinFas)")
    List<XinFa> findMenPaiXinFasByXinFaName(@QueryParam("xinFaName") String xinFaName);

    default List<String> findMenPaiXinFaNamesByXinFaName(String xinFaName) {
        return findMenPaiXinFasByXinFaName(xinFaName).stream()
                .map(XinFa::getName)
                .collect(Collectors.toList());
    }

    @Select("from MenPai")
    List<MenPai> findMenPaiList();

    @Select("select name from MenPai")
    List<String> findMenPaiNameList();
}
