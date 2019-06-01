package top.yzlin.test;

import com.alibaba.fastjson.JSON;
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
import top.yzlin.jx3strategystation.entity.game.*;
import top.yzlin.jx3strategystation.service.ArticleService;
import top.yzlin.jx3strategystation.service.CommentService;
import top.yzlin.jx3strategystation.service.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        MenPai menPai = session.get(MenPai.class, 171);
        System.out.println(JSON.toJSONString(menPai));
    }

    @Test
    public void saveMenpai() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/天策门派.json"), "utf-8");
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
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/天策门派.json"), "utf-8");
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
        Query<QiXueGroup> query = session.createQuery("from QiXueGroup where qiXueGroupId>335", QiXueGroup.class);
        List<QiXueGroup> list = query.list();
        System.out.println(JSON.toJSONString(list));


    }

    @Test
    public void saveQiXueGroup() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/铁牢奇穴.json"), "utf-8");
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
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/menpai/铁牢奇穴.json"), "utf-8");
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
}
