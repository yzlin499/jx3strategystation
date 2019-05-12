package top.yzlin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.community.Comment;
import top.yzlin.jx3strategystation.entity.user.User;
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


    @Test
    public void fileTest() {
        User user = userService.findUserByUserNameAndPassword("yzlin", "q1w2e3r4");
        BaseArticle articleById = new BaseArticle(16);
        Comment comment = new Comment();
        comment.setArticle(articleById);
        comment.setContent("<p>aaaqqqa</p>");
        comment.setUser(user);
        comment.setArticle(articleService.findArticleById(comment.getArticle().getArticleId()));
        commentService.saveComment(comment);
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
