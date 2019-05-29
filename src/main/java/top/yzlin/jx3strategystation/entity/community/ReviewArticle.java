package top.yzlin.jx3strategystation.entity.community;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "reviewArticle")
public class ReviewArticle {
    @Id
    @GeneratedValue
    private int reviewId;

    @OrderColumn
    @OneToOne(targetEntity = BaseArticle.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private BaseArticle article;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public BaseArticle getArticle() {
        return article;
    }

    public void setArticle(BaseArticle article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "ReviewArticle{" +
                "reviewId=" + reviewId +
                ", article=" + article +
                '}';
    }
}
