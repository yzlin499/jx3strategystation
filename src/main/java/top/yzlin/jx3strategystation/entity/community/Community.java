package top.yzlin.jx3strategystation.entity.community;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "community")
public class Community {
    private int communityId;
    private String name;
    private String describe;

    @Id
    @GeneratedValue
    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Community{" +
                "communityId=" + communityId +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}
