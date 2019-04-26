package top.yzlin.jx3strategystation.entity.game;

public class QiXue {
    public static final Skill PASSIVE = null;
    private int qiXueId;
    private String name;
    private String describe;
    private SkillType[] skillTypes;
    private Skill skill = PASSIVE;

    public SkillType[] getSkillTypes() {
        return skillTypes;
    }

    public void setSkillTypes(SkillType[] skillTypes) {
        this.skillTypes = skillTypes;
    }

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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
