package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Save;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.user.User;


public interface UserDAO {

    @Select("from User u where u.userName=:userName and u.password=:password")
    User findUserByUserNameAndPassword(@QueryParam("userName") String userName,
                                       @QueryParam("password") String password);

    @Save
    int saveUser(User user);
}
