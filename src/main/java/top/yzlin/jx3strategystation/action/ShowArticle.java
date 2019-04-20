package top.yzlin.jx3strategystation.action;

import com.opensymphony.xwork2.ActionSupport;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.user.User;

public class ShowArticle extends ActionSupport {
    private int articleId;
    private String userName;
    private BaseArticle article;

    public BaseArticle getArticle() {
        if (article == null) {
            article = new BaseArticle();
            article.setTitle("实例标题");
            article.setContent("<p>实例文本实例文本实例文本实例文本</p>");
            User user = new User();
            user.setNickName("实例用户名");
            user.setPortrait("/static/img/test/testHead.jpg");
            article.setUser(user);
        }
        return article;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        try {
            this.articleId = Integer.parseInt(articleId);
        } catch (NumberFormatException e) {
            this.articleId = -1;
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
