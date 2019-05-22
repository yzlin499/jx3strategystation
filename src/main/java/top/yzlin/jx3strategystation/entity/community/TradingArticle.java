package top.yzlin.jx3strategystation.entity.community;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("trading")
public class TradingArticle extends BaseArticle {
    private int minGold;
    private int maxGold;
    private int ratio;
    private String district;
    private String buySell;

    public int getMinGold() {
        return minGold;
    }

    public void setMinGold(int minGold) {
        this.minGold = minGold;
    }

    public int getMaxGold() {
        return maxGold;
    }

    public void setMaxGold(int maxGold) {
        this.maxGold = maxGold;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBuySell() {
        return buySell;
    }

    public void setBuySell(String buySell) {
        this.buySell = buySell;
    }
}
