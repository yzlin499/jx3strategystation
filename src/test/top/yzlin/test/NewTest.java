package top.yzlin.test;

import com.alibaba.fastjson.JSONObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yzlin.jx3strategystation.entity.game.Skill;
import top.yzlin.jx3strategystation.entity.game.XinFa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
@ActiveProfiles("dev")
public class NewTest {

    @Autowired
    private SessionFactory sessionFactory;

//    @Value("#{imgPath}")
//    private String imgPath;

    @Test
    public void test() {
        Session session = sessionFactory.openSession();
        XinFa xinFa = session.get(XinFa.class, 172);
        JSONObject jo = new JSONObject();
        for (Skill skill : xinFa.getSkills()) {
            jo.put(skill.getName(), "");
        }
        System.out.println(jo);
//        session.get(QiXue.class, 95)
    }
}