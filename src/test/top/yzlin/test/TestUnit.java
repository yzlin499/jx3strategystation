package top.yzlin.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;
import top.yzlin.img.ImgTest;
import top.yzlin.jx3strategystation.entity.game.*;
import top.yzlin.jx3strategystation.service.ArticleService;
import top.yzlin.jx3strategystation.service.CommentService;
import top.yzlin.jx3strategystation.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
@ActiveProfiles("dev")
public class TestUnit {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void test() {
        Session session = sessionFactory.openSession();
        MenPai menPai = session.get(MenPai.class, 649);
        System.out.println(JSON.toJSONString(menPai));
    }

    @Test
    public void saveMenpai() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/藏剑门派.json"), "utf-8");
        MenPai menPai = JSON.parseObject(s).toJavaObject(MenPai.class);
        session.save(menPai);
        transaction.commit();
    }

    @Test
    public void setSkillType() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<SkillType> skillTypeList = session.createQuery("from SkillType ", SkillType.class).list();
        Map<String, SkillType> collect = skillTypeList.stream().collect(Collectors.toMap(SkillType::getTitle, v -> v));
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/藏剑门派.json"), "utf-8");
        MenPai menPai = JSON.parseObject(s).toJavaObject(MenPai.class);
        for (XinFa xinFa : menPai.getXinFas()) {
            for (Skill skill : xinFa.getSkills()) {
                for (SkillType skillType : skill.getSkillTypes()) {
                    SkillType skillType1 = collect.get(skillType.getTitle());
                    if (skillType1 == null) {
                        System.out.println(skillType.getTitle());
                    }
                    skillType.setTypeId(skillType1.getTypeId());
                }
            }
        }
        System.out.println(JSON.toJSONString(menPai));
        transaction.commit();

    }

    @Test
    public void findQiXueGroup() {
        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
        Query<QiXueGroup> query = session.createQuery("from QiXueGroup where qiXueGroupId>590", QiXueGroup.class);
        List<QiXueGroup> list = query.list();
        System.out.println(JSON.toJSONString(list));


    }

    @Test
    public void saveQiXueGroup() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/藏剑奇穴.json"), "utf-8");
        List<QiXueGroup> qiXueGroups = JSON.parseArray(s).toJavaList(QiXueGroup.class);
        qiXueGroups.forEach(session::save);
        transaction.commit();
    }

    private void setSkillTypeId(Session session) throws IOException {
        List<SkillType> skillTypeList = session.createQuery("from SkillType ", SkillType.class).list();
        Map<String, SkillType> collect = skillTypeList.stream().collect(Collectors.toMap(SkillType::getTitle, v -> v));
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/霸刀奇穴.json"), "utf-8");
        List<QiXueGroup> qiXueGroups = JSON.parseArray(s).toJavaList(QiXueGroup.class);
        for (int i = 0; i < qiXueGroups.size(); i++) {
            QiXueGroup qiXueGroup = qiXueGroups.get(i);
            qiXueGroup.setQiXueGroupId(0);
            qiXueGroup.setQiXueIndex(i);
            for (QiXue qiXue : qiXueGroup.getQiXues()) {
                qiXue.setQiXueId(0);
                for (SkillType skillType : qiXue.getSkillTypes()) {
                    SkillType skillType1 = collect.get(skillType.getTitle());
                    if (skillType1 == null) {
                        System.out.println(skillType.getTitle());
                    }
                    skillType.setTypeId(skillType1.getTypeId());
                }
            }
        }
        System.out.println(JSON.toJSONString(qiXueGroups));
    }

    @Test
    public void setQiXueType() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<SkillType> skillTypeList = session.createQuery("from SkillType ", SkillType.class).list();
        Map<String, SkillType> collect = skillTypeList.stream().collect(Collectors.toMap(SkillType::getTitle, v -> v));
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/藏剑奇穴.json"), "utf-8");
        List<QiXueGroup> qiXueGroups = JSON.parseArray(s).toJavaList(QiXueGroup.class);
        for (QiXueGroup qiXueGroup : qiXueGroups) {
            for (QiXue qiXue : qiXueGroup.getQiXues()) {
                for (SkillType skillType : qiXue.getSkillTypes()) {
                    SkillType skillType1 = collect.get(skillType.getTitle());
                    if (skillType1 == null) {
                        System.out.println(skillType.getTitle());
                    }
                    skillType.setTypeId(skillType1.getTypeId());
                }
            }
        }
        System.out.println(JSON.toJSONString(qiXueGroups));
        transaction.commit();
    }


    @Test
    public void setQiXueImg() {
        //第一个检查点
        JSONObject netData = JSON.parseObject(Tools.sendGet("https://api.ipsfan.com/jx3qx/cj.json", ""));
        Map<String, String> qiXueCollect = netData.getJSONArray("data")
                //第二个检查点
                .getJSONObject(0)
                .getJSONArray("kungfuLevel")
                .toJavaList(JSONObject.class)
                .stream()
                .flatMap(ja -> {
                    List<JSONObject> kungfuSkills = ja.getJSONArray("kungfuSkills").toJavaList(JSONObject.class);
                    List<JSONObject> forceSkills = ja.getJSONArray("forceSkills").toJavaList(JSONObject.class);
                    forceSkills.forEach(jo -> jo.put("name", jo.getString("skillName")));
                    return Stream.concat(kungfuSkills.stream(), forceSkills.stream());
                }).collect(Collectors.toMap(k -> k.getString("name"), v -> v.getJSONObject("icon").getString("FileName")));
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //第三个检查点
        for (QiXueGroup qiXueGroup : session.get(XinFa.class, 650).getQiXueGroups()) {
            for (QiXue qiXue : qiXueGroup.getQiXues()) {
                String imgUrl = qiXueCollect.get(qiXue.getName());
                if (imgUrl != null) {
                    qiXue.setImgBase64(ImgTest.downloadImg(imgUrl));
                }
            }
        }
        transaction.commit();
    }

    @Test
    public void setSkillImg() throws IOException {
        //第一个检查点
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/剑纯技能图片.json"), "utf-8");
        JSONObject jo = JSON.parseObject(s);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //第二个检查点
        for (Skill skill : session.get(XinFa.class, 572).getSkills()) {
            String imgUrl = jo.getString(skill.getName());
            if (imgUrl != null) {
                skill.setImgBase64(ImgTest.downloadImg(imgUrl));
            }
        }
        transaction.commit();
    }
}
