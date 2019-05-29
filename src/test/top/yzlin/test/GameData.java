package top.yzlin.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.util.ResourceUtils;
import top.yzlin.jx3strategystation.entity.game.*;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GameData {
    private Pattern pattern = Pattern.compile("class=\"font-100\">(?<content>.*?)</span>");
    private Pattern coolDownTimePattern = Pattern.compile("class=\"font-165\">(?<content>.*?)</span>");

    @Test
    public void getData() throws IOException {
        String data = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/铁牢奇穴.json"), "utf-8");
        JSONArray objects = JSON.parseArray(data);
        List<String[]> qixues = objects.toJavaList(String[].class);
        QiXueGroup[] qiXueGroups = new QiXueGroup[12];
        for (int i = 0; i < qiXueGroups.length; i++) {
            qiXueGroups[i] = new QiXueGroup();
            qiXueGroups[i].setQiXueIndex(i);
            qiXueGroups[i].setQiXues(Stream.of(qixues.get(i)).map(t -> {
                QiXue qiXue = new QiXue();
                qiXue.setName(t);
                qiXue.setDescribe(getDescribe(t));
                qiXue.setSkillTypes(new SkillType[0]);
                return qiXue;
            }).toArray(QiXue[]::new));
        }
        System.out.println(JSON.toJSONString(qiXueGroups));
    }

    @Test
    public void getSkillData() throws IOException {
        String data = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/天策门派.json"), "utf-8");
        JSONObject jsonObject = JSON.parseObject(data);
        MenPai menPai = jsonObject.toJavaObject(MenPai.class);
        for (XinFa xinFa : menPai.getXinFas()) {
            for (Skill skill : xinFa.getSkills()) {
                skill.setSkillTypes(new SkillType[0]);
                skill.setDescribe(getDescribe(skill.getName()));
            }
        }
        System.out.println(JSON.toJSONString(menPai));
    }

    public void qixueGetDescribe() {

//        MenPai menPai = jsonObject.toJavaObject(MenPai.class);
//        for (Skill skill : menPai.getXinFas()[0].getSkills()) {
//            skill.setDescribe(getDescribe(skill.getName()));
//        }
//        System.out.println(JSON.toJSONString(menPai));
//        JSONArray objects = JSON.parseArray(data);
//        List<QiXueGroup> qiXueGroups = objects.toJavaList(QiXueGroup.class);
//        for (QiXueGroup qiXueGroup : qiXueGroups) {
//            for (QiXue qiXue : qiXueGroup.getQiXues()) {
//                qiXue.setDescribe(getDescribe(qiXue.getName()));
//            }
//        }
//        System.out.println(JSON.toJSONString(qiXueGroups));
//        System.out.println(getDescribe(name));
    }

    @Test
    public void describeTest() {
        System.out.println();
    }


    private String getDescribe(String name) {
        JSONObject data = JSON.parseObject(Tools.sendGet("https://haiman.io/api/jx3/search-data/skill", "q=" + name + "&offset=0&limit=25"));
        JSONArray dataJSONArray = data.getJSONArray("data");
        if (dataJSONArray.size() <= 0) {
            return null;
        }
        String tip = dataJSONArray.getJSONObject(0).getString("szTip");
        Matcher matcher = pattern.matcher(tip);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group("content")).append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
