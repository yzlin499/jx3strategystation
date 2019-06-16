package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.game.MenPai;
import top.yzlin.jx3strategystation.entity.game.QiXueGroup;
import top.yzlin.jx3strategystation.entity.game.XinFa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public interface QiXueGroupDAO {

    @Select("from MenPai where name=:name")
    MenPai findMenPaiByName(@QueryParam("name") String name);

    @Select("from XinFa where name=:name")
    XinFa findXinFaByName(@QueryParam("name") String name);

    default List<QiXueGroup> findQiXueGroupByXinFaName(String xinFaName) {
        XinFa xinFaByName = findXinFaByName(xinFaName);
        if (xinFaByName != null) {
            return Arrays.asList(xinFaByName.getQiXueGroups());
        } else {
            return Collections.emptyList();
        }

    }
}
