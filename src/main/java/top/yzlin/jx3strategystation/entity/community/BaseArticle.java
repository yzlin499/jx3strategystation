package top.yzlin.jx3strategystation.entity.community;

import top.yzlin.jx3strategystation.entity.user.User;

public class BaseArticle {
    private int articleId;
    private User user;
    private String imgPath;
    private String title;
    private Community community;
    private String content;

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public void setCommunity(Community community) {
//        this.community = community;
//    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getArticleId() {
        return articleId;
    }


    public String getImgPath() {
        return imgPath;
    }

    public String getTitle() {
        return title;
    }

    public Community getCommunity() {
        return community;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "BaseArticle{" +
                "articleId=" + articleId +
                ", user=" + user +
                ", imgPath='" + imgPath + '\'' +
                ", title='" + title + '\'' +
                ", community=" + community +
                ", content='" + content + '\'' +
                '}';
    }
}
