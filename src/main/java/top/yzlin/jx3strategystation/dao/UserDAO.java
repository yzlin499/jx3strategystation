package top.yzlin.jx3strategystation.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.yzlin.jx3strategystation.entity.user.User;

@Repository
public class UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void saveUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

//    @Select("from User u where u.userId=:id")
//    User findUserById(@QueryParam("id") int id);
//
//    @SaveOrUpdate
//    void deletdUser(User user);
}
