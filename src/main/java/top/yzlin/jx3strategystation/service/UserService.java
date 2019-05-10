package top.yzlin.jx3strategystation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yzlin.jx3strategystation.dao.UserDAO;
import top.yzlin.jx3strategystation.entity.user.User;

@Service
@Transactional
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public void saveUser(User user) {
        userDAO.saveUser(user);
    }


}
