package top.yzlin.jx3strategystation.entity.community;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("announcement")
public class AnnouncementArticle extends BaseArticle {

    @Override
    public String toString() {
        return "AnnouncementArticle{" +
                "articleId=" + getArticleId() +
                ", user=" + getUser() +
                ", imgPath='" + getImgPath() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", community=" + getCommunity() +
                ", content='" + getContent() + '\'' +
                '}';
    }
}
