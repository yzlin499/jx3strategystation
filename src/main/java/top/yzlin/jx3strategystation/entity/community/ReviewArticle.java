package top.yzlin.jx3strategystation.entity.community;


public class ReviewArticle {
    private int reviewId;
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
}
