package top.yzlin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yzlin.jx3strategystation.entity.community.CommonArticle;
import top.yzlin.jx3strategystation.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationConfig.xml"})
@ActiveProfiles("dev")
public class TestUnit {

    @Autowired
    private ArticleService articleService;

    @Test
    public void fileTest() {
        CommonArticle article = new CommonArticle();
        article.setTitle("title");
        article.setImgPath("imgpath");
        article.setContent("content");
        articleService.saveArticleDAO(article);
    }
}
