package top.yzlin.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yzlin.jx3strategystation.entity.game.SkillType;
import top.yzlin.jx3strategystation.service.ArticleService;
import top.yzlin.jx3strategystation.service.CommentService;
import top.yzlin.jx3strategystation.service.UserService;

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
    public void fileTest() {
        String[] a = {"冲刺", "打断", "减伤", "闪避", "爆发", "控制", "减速", "锁足", "定身", "眩晕", "击倒", "缴械", "解控", "嘲讽", "减疗", "位移", "封轻功", "加速", "封内", "无敌", "免控", "推", "拉"};
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        SkillType[] skillTypes = new SkillType[a.length];
        for (int i = 0; i < skillTypes.length; i++) {
            skillTypes[i] = new SkillType();
            skillTypes[i].setTitle(a[i]);
            session.save(skillTypes[i]);
        }
//        MenPai menPai=new MenPai();
//        menPai.setName("纯阳");
        transaction.commit();
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
}
