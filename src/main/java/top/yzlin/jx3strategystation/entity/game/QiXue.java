package top.yzlin.jx3strategystation.entity.game;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "qiXue")
public class QiXue {
    public static final Skill PASSIVE = null;
    private int qiXueId;
    private String name;
    private String describe;
    private SkillType[] skillTypes;
    private Skill skill = PASSIVE;

    @OrderColumn
    @OneToMany(targetEntity = SkillType.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public SkillType[] getSkillTypes() {
        return skillTypes;
    }

    public void setSkillTypes(SkillType[] skillTypes) {
        this.skillTypes = skillTypes;
    }

    @Id
    @GeneratedValue
    public int getQiXueId() {
        return qiXueId;
    }

    public void setQiXueId(int qiXueId) {
        this.qiXueId = qiXueId;
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

    public static Skill getPASSIVE() {
        return PASSIVE;
    }

    @OrderColumn
    @OneToOne(targetEntity = Skill.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "QiXue{" +
                "qiXueId=" + qiXueId +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", skillTypes=" + Arrays.toString(skillTypes) +
                ", skill=" + skill +
                '}';
    }
}
