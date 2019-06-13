package top.yzlin.jx3strategystation.entity.user;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "banedUser")
public class BanedUser {
    private int banedUserId;
    private User user;

    @Id
    @GeneratedValue
    public int getBanedUserId() {
        return banedUserId;
    }

    public void setBanedUserId(int banedUserId) {
        this.banedUserId = banedUserId;
    }

    @OneToOne
    @OrderColumn
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BanedUser{" +
                "banedUserId=" + banedUserId +
                ", user=" + user +
                '}';
    }
}
