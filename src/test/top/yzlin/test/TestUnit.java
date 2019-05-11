package top.yzlin.test;

import com.alibaba.fastjson.JSON;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
@ActiveProfiles("dev")
public class TestUnit {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void fileTest() {
        Session session = sessionFactory.openSession();
        System.out.println(JSON.toJSONString(session.createQuery
                ("from BaseArticle where articleId=16 and user.userName='yzlina'", BaseArticle.class).list()));
    }
}
