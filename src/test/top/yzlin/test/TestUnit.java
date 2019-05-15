package top.yzlin.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;
import top.yzlin.jx3strategystation.entity.game.QiXue;
import top.yzlin.jx3strategystation.entity.game.QiXueGroup;
import top.yzlin.jx3strategystation.entity.game.SkillType;
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
    public void fileTest() throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/badaoqixue.json"), "utf-8");
        List<QiXueGroup> qiXueGroups = JSON.parseArray(s).toJavaList(QiXueGroup.class);
        qiXueGroups.forEach(session::save);
        transaction.commit();


//        SkillType[] skillTypes = new SkillType[a.length];
//        for (int i = 0; i < skillTypes.length; i++) {
//            skillTypes[i] = new SkillType();
//            skillTypes[i].setTitle(a[i]);
//            session.save(skillTypes[i]);
//        }
//        MenPai menPai=new MenPai();
//        menPai.setName("纯阳");
//        transaction.commit();
//        System.out.println(commentService.findCommentByArticleId(16));
//        Comment comment=new Comment();
//        User user=new User();
//        user.setUserId(1);
//        BaseArticle yzlin = new BaseArticle();
//        yzlin.setArticleId(16);
//        comment.setArticle(yzlin);
//        comment.setUser(user);
//        comment.setContent("<p>a</p>");
//        commentService.saveComment(comment);

    }

    private void setSkillTypeId(Session session) throws IOException {
        List<SkillType> skillTypeList = session.createQuery("from SkillType ", SkillType.class).list();
        Map<String, SkillType> collect = skillTypeList.stream().collect(Collectors.toMap(SkillType::getTitle, v -> v));
        String s = FileUtils.readFileToString(ResourceUtils.getFile("classpath:data/badaoqixue.json"), "utf-8");
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
}
