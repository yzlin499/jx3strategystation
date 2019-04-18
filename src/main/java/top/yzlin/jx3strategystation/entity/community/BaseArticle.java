package top.yzlin.jx3strategystation.entity.community;

public class BaseArticle {
    private int articleId;
    private int userId;
    private String imgPath;
    private String title;
    private Community community;
    private String content;

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getUserId() {
        return userId;
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
                ", userId=" + userId +
                ", imgPath='" + imgPath + '\'' +
                ", title='" + title + '\'' +
                ", community=" + community +
                ", content='" + content + '\'' +
                '}';
    }
}
