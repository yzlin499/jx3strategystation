package top.yzlin.jx3strategystation.entity.game;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "xinFa")
public class XinFa{
    private int xinFaId;
    private String name;
    private String describe;
    private Skill[] skills;
    private QiXueGroup[] qiXueGroups;

    @Id
    @GeneratedValue
    public int getXinFaId() {
        return xinFaId;
    }

    public void setXinFaId(int xinFaId) {
        this.xinFaId = xinFaId;
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

    @OrderColumn
    @OneToMany(targetEntity = Skill.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }

    @OrderColumn
    @OneToMany(targetEntity = QiXueGroup.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public QiXueGroup[] getQiXueGroups() {
        return qiXueGroups;
    }

    public void setQiXueGroups(QiXueGroup[] qiXueGroups) {
        this.qiXueGroups = qiXueGroups;
    }

    @Override
    public String toString() {
        return "XinFa{" +
                "xinFaId=" + xinFaId +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", skills=" + Arrays.toString(skills) +
                ", qiXueGroups=" + Arrays.toString(qiXueGroups) +
                '}';
    }
}
