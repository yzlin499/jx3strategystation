package top.yzlin.jx3strategystation.entity.community;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import top.yzlin.jx3strategystation.entity.user.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    private int commentId;
    private BaseArticle article;
    private User user;
    private String content;

    @Id
    @GeneratedValue
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }


    @OrderColumn
    @ManyToOne(targetEntity = BaseArticle.class)
    @Cascade(CascadeType.MERGE)
    public BaseArticle getArticle() {
        return article;
    }

    public void setArticle(BaseArticle article) {
        this.article = article;
    }

    @OrderColumn
    @OneToOne(targetEntity = User.class)
    @Cascade(CascadeType.MERGE)
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
                "article=" + article +
                ", user=" + user +
                ", content='" + content + '\'' +
                '}';
    }
}