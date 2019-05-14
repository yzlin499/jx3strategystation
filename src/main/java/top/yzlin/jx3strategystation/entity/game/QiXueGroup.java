package top.yzlin.jx3strategystation.entity.game;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "qiXueGroup")
public class QiXueGroup {
    private int qiXueGroupId;
    private int qiXueIndex;
    private QiXue[] qiXues;

    @Id
    @GeneratedValue
    public int getQiXueGroupId() {
        return qiXueGroupId;
    }

    public void setQiXueGroupId(int qiXueGroupId) {
        this.qiXueGroupId = qiXueGroupId;
    }

    public int getQiXueIndex() {
        return qiXueIndex;
    }

    public void setQiXueIndex(int qiXueIndex) {
        this.qiXueIndex = qiXueIndex;
    }

    @OrderColumn
    @OneToMany(targetEntity = QiXue.class)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public QiXue[] getQiXues() {
        return qiXues;
    }

    public void setQiXues(QiXue[] qiXues) {
        this.qiXues = qiXues;
    }

    @Override
    public String toString() {
        return "QiXueGroup{" +
                "qiXueGroupId=" + qiXueGroupId +
                ", qiXueIndex=" + qiXueIndex +
                ", qiXues=" + Arrays.toString(qiXues) +
                '}';
    }
}
