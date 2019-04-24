package top.yzlin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yzlin.jx3strategystation.entity.templates.District;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
public class TestUnit {

    @Autowired
    private District[] district;

    @Test
    public void fileTest() {
        System.out.println(Arrays.toString(district));
    }
}
