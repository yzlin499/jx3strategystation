package top.yzlin.jx3strategystation.entity.game;


public enum SkillType {
    /**
     *
     */
    RUSH("冲刺"),
    BREAK("打断"),
    REDUCTION_INJURY("减伤"),
    DODGE("闪避"),
    BURST("爆发"),
    CONTROL("控制"),
    SLOW("减速"),
    LOCKING_FEET("锁足"),
    IMMOBILIZED("定身"),
    VERTIGO("眩晕"),
    KNOCK_DOWN("击倒"),
    DISARM("缴械"),
    SOLUTION_CONTROL("解控"),
    SARCASM("嘲讽"),
    HEALING_REDUCTION("减疗"),
    DISPLACEMENT("位移"),
    BAN_DISPLACEMENT("封轻功"),
    SPEED_UP("加速"),
    BAN_MAGIC("封内"),
    INVINCIBLE("无敌"),
    IMMUNE_CONTROL("免控"),
    PUSH("推"),
    PULL("拉");


    private String title;

    SkillType(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }
}
