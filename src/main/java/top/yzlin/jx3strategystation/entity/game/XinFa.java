package top.yzlin.jx3strategystation.entity.game;

public class XinFa{
    private int xinFaId;
    private String name;
    private String describe;
    private Skill[] skills;
    private QiXueGroup[] qiXueGroups;

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

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }

    public QiXueGroup[] getQiXueGroups() {
        return qiXueGroups;
    }

    public void setQiXueGroups(QiXueGroup[] qiXueGroups) {
        this.qiXueGroups = qiXueGroups;
    }
}
