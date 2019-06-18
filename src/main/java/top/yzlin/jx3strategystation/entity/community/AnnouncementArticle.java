package top.yzlin.jx3strategystation.entity.community;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("announcement")
public class AnnouncementArticle extends BaseArticle {


    private String instance;

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    @Override
    public String toString() {
        return "AnnouncementArticle{" +
                "instance='" + instance + '\'' +
                "} " + super.toString();
    }
}
