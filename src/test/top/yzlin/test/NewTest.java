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
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
@ActiveProfiles("dev")
public class NewTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ArticleService articleService;

//    @Value("#{imgPath}")
//    private String imgPath;

    @Test
    public void test() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User admin = new User();
        admin.setPassword("q1w2e3r4");
        admin.setPortrait("/static/img/test/testHead.jpg");
        admin.setMail("test@test.com");
        admin.setNickName("第二个用户并管理");
        admin.setUserId(17);
        admin.setUserName("commonUser");
        session.save(admin);
        transaction.commit();

    }
}