package top.yzlin.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameData {
    private Pattern pattern = Pattern.compile("class=\"font-100\">(?<content>.*?)</span>");

    @Test
    public void getData() {
        String name = "雷锋";
    }

    private String getDescribe(String name) {
        JSONObject data = JSON.parseObject(Tools.sendGet("https://haiman.io/api/jx3/search-data/skill", "q=" + name + "&offset=0&limit=25"));
        System.out.println(data);
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
