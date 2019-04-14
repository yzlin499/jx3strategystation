package top.yzlin.jx3strategystation.entity.game;

public class Skill {
    private int skillId;
    private String name;
    /**距离*/
    private int distance;
    /**兵器*/
    private String arm;
    /**技能类型*/
    private SkillType[] skillTypes;
    /**冷却时间*/
    private int coolDownTime;
    /**蓄力时间*/
    private double storingForce;
    /**消耗*/
    private int consumption;
    /**秘籍*/
    private String[] secretBook;
    /**描述*/
    private String describe;

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getArm() {
        return arm;
    }

    public void setArm(String arm) {
        this.arm = arm;
    }

    public SkillType[] getSkillTypes() {
        return skillTypes;
    }

    public void setSkillTypes(SkillType[] skillTypes) {
        this.skillTypes = skillTypes;
    }

    public int getCoolDownTime() {
        return coolDownTime;
    }

    public void setCoolDownTime(int coolDownTime) {
        this.coolDownTime = coolDownTime;
    }

    public double getStoringForce() {
        return storingForce;
    }

    public void setStoringForce(double storingForce) {
        this.storingForce = storingForce;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public String[] getSecretBook() {
        return secretBook;
    }

    public void setSecretBook(String[] secretBook) {
        this.secretBook = secretBook;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
