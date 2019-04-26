package top.yzlin.jx3strategystation.entity.community;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import top.yzlin.jx3strategystation.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class BaseArticle {
    private int articleId;
    private User user;
    private String imgPath;
    private String title;
    private Community community;
    private String content;

    @Id
    @GeneratedValue
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @OrderColumn
    @OneToOne(targetEntity = User.class)
    @Cascade(CascadeType.SAVE_UPDATE)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OrderColumn
    @OneToOne(targetEntity = Community.class)
    @Cascade(CascadeType.SAVE_UPDATE)
    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
