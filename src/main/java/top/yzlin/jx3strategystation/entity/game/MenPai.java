package top.yzlin.jx3strategystation.entity.game;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "menPai")
public class MenPai {
    private int menPaiId;
    private String name;
    private XinFa[] xinFas;
    private String describe;

    @Id
    @GeneratedValue
    public int getMenPaiId() {
        return menPaiId;
    }

    public void setMenPaiId(int menPaiId) {
        this.menPaiId = menPaiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OrderColumn
    @OneToMany(targetEntity = XinFa.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public XinFa[] getXinFas() {
        return xinFas;
    }

    public void setXinFas(XinFa[] xinFas) {
        this.xinFas = xinFas;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
