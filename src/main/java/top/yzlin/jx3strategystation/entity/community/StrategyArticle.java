package top.yzlin.jx3strategystation.entity.community;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("strategy")
public class StrategyArticle extends BaseArticle {
    private String instance;

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}
