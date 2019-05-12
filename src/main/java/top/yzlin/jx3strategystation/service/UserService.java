package top.yzlin.jx3strategystation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yzlin.jx3strategystation.dao.UserDAO;
import top.yzlin.jx3strategystation.entity.user.User;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public User findUserByUserNameAndPassword(User user) {
        return findUserByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    public User findUserByUserNameAndPassword(String userName, String password) {
        return userDAO.findUserByUserNameAndPassword(userName, password);
    }

    public int saveUser(User user) {
        return userDAO.saveUser(user);
    }
}
