package top.yzlin.jx3strategystation.entity.community;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import top.yzlin.jx3strategystation.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private int articleId;
    private User user;
    private String content;

    @Id
    @OrderColumn
    @OneToOne(targetEntity = BaseArticle.class)
    @Cascade(CascadeType.SAVE_UPDATE)
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "articleId=" + articleId +
                ", user=" + user +
                ", content='" + content + '\'' +
                '}';
    }
}