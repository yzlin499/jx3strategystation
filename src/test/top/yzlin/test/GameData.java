package top.yzlin.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.util.ResourceUtils;
import top.yzlin.jx3strategystation.entity.game.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameData {
    private Pattern pattern = Pattern.compile("class=\"font-100\">(?<content>.*?)</span>");
    private Pattern coolDownTimePattern = Pattern.compile("class=\"font-165\">(?<content>.*?)</span>");
    private int count = 0;

    @Test
    public void createSkill() {
        String[] skills = {"莺鸣柳", "云溪松", "泉凝月", "醉月", "啸日", "听雷", "梦泉虎跑", "玉泉鱼跃", "黄龙吐翠", "平湖断月", "玉虹贯日",
                "九溪弥烟", "风来吴山", "峰插云景", "鹤归孤山", "云飞玉皇", "夕照雷峰", "风吹荷", "惊涛", "霞流宝石", "探梅", "松舍问霞"};
        List<Skill> skillList = Arrays.stream(skills).map(s -> {
            Skill skill = new Skill();
            skill.setName(s);
            skill.setArm("短兵");
            skill.setSkillTypes(new SkillType[0]);
            skill.setDescribe(getDescribe(s));
            return skill;
        }).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(skillList));
    }

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

    @Test
    public void getQiXueData() throws IOException {
        JSONObject netData = JSON.parseObject(Tools.sendGet("https://api.ipsfan.com/jx3qx/cj.json", ""));
        Map<String, String> qiXueCollect = netData.getJSONArray("data")
                .getJSONObject(0)
                .getJSONArray("kungfuLevel")
                .toJavaList(JSONObject.class)
                .stream()
                .flatMap(ja -> {
                    List<JSONObject> kungfuSkills = ja.getJSONArray("kungfuSkills").toJavaList(JSONObject.class);
                    List<JSONObject> forceSkills = ja.getJSONArray("forceSkills").toJavaList(JSONObject.class);
                    forceSkills.forEach(jo -> jo.put("name", jo.getString("skillName")));
                    return Stream.concat(kungfuSkills.stream(), forceSkills.stream());
                }).collect(Collectors.toMap(k -> k.getString("name"), v -> v.getString("desc")));
        String data = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/藏剑奇穴.json"), "utf-8");
        QiXueGroup[] qiXueGroups = JSON.parseArray(data).toJavaList(String[].class).stream().map(i -> {
            QiXueGroup qiXueGroup = new QiXueGroup();
            qiXueGroup.setQiXueIndex(count++);
            qiXueGroup.setQiXues(Arrays.stream(i).map(j -> {
                QiXue qiXue = new QiXue();
                qiXue.setName(j);
                qiXue.setDescribe(qiXueCollect.get(j));
                qiXue.setSkillTypes(new SkillType[0]);
                return qiXue;
            }).toArray(QiXue[]::new));
            return qiXueGroup;
        }).toArray(QiXueGroup[]::new);
        System.out.println(JSON.toJSONString(qiXueGroups));
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
    public void describeTest() throws IOException {
        String data = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/纯阳门派.json"), "UTF-8");
        MenPai menPai = JSON.parseObject(data).toJavaObject(MenPai.class);
        System.out.println(menPai.getXinFas()[0].getSkills()[0]);
        System.out.println(menPai.getXinFas()[1].getSkills()[0]);
        System.out.println(menPai.getXinFas()[0].getSkills()[0] == menPai.getXinFas()[1].getSkills()[0]);

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
