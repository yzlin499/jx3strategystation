package top.yzlin.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yzlin.jx3strategystation.entity.community.AnnouncementArticle;
import top.yzlin.jx3strategystation.service.GameDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
@ActiveProfiles("dev")
public class NewTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private GameDataService gameDataService;

//    @Value("#{imgPath}")
//    private String imgPath;

    @Test
    public void test() {
        Session session = sessionFactory.openSession();
        AnnouncementArticle xinFa = session.get(AnnouncementArticle.class, 675);
        System.out.println(xinFa);

    }
}