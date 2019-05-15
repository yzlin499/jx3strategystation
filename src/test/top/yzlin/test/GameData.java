package top.yzlin.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;
import top.yzlin.jx3strategystation.entity.game.QiXue;
import top.yzlin.jx3strategystation.entity.game.QiXueGroup;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameData {
    private Pattern pattern = Pattern.compile("class=\"font-100\">(?<content>.*?)</span>");

    @Test
    public void getData() throws IOException {
        String data = FileCopyUtils.copyToString(new FileReader(new File("D:\\49968\\Workspaces\\InttlliJ IDEA\\jx3strategystation\\src\\main\\resources\\data\\badaoqixue.json")));
        JSONArray objects = JSON.parseArray(data);
        List<QiXueGroup> qiXueGroups = objects.toJavaList(QiXueGroup.class);
        for (QiXueGroup qiXueGroup : qiXueGroups) {
            for (QiXue qiXue : qiXueGroup.getQiXues()) {
                qiXue.setDescribe(getDescribe(qiXue.getName()));
            }
        }
        System.out.println(JSON.toJSONString(qiXueGroups));
//        System.out.println(getDescribe(name));
    }

    private String getDescribe(String name) {
        JSONObject data = JSON.parseObject(Tools.sendGet("https://haiman.io/api/jx3/search-data/skill", "q=" + name + "&offset=0&limit=25"));
//        System.out.println(data);
        JSONArray dataJSONArray = data.getJSONArray("data");
        if (dataJSONArray.size() <= 0) {
            return null;
        }
        String tip = dataJSONArray.getJSONObject(0).getString("szTip");
        Matcher matcher = pattern.matcher(tip);
        if (matcher.find()) {
            return matcher.group("content");
        } else {
            return null;
        }
    }
}
