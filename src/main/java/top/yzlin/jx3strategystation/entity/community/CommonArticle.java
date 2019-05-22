package top.yzlin.jx3strategystation.entity.community;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("common")
public class CommonArticle extends BaseArticle {
    @Override
    public String toString() {
        return "CommonArticle{" +
                "articleId=" + getArticleId() +
                ", user=" + getUser() +
                ", imgPath='" + getImgPath() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", community=" + getCommunity() +
                ", content='" + getContent() + '\'' +
                '}';
    }
}
