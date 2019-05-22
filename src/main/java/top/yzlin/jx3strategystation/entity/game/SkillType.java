package top.yzlin.jx3strategystation.entity.game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skillType")
public class SkillType {
    private int typeId;
    private String title;

    @Id
    @GeneratedValue
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SkillType{" +
                "typeId=" + typeId +
                ", title='" + title + '\'' +
                '}';
    }
}
