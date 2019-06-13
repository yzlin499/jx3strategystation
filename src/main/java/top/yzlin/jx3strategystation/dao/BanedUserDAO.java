package top.yzlin.jx3strategystation.dao;

import top.yzlin.jx3strategystation.database.annotation.Delete;
import top.yzlin.jx3strategystation.database.annotation.QueryParam;
import top.yzlin.jx3strategystation.database.annotation.Save;
import top.yzlin.jx3strategystation.database.annotation.Select;
import top.yzlin.jx3strategystation.entity.user.BanedUser;

import java.util.List;

public interface BanedUserDAO {

    @Select("from BanedUser")
    List<BanedUser> findBanedUserList();

    @Delete("delete from BanedUser where banedUserId=:banedUserId")
    void deleteBanedUserByBanedUserId(@QueryParam("banedUserId") int id);

    @Save
    int saveBanedUser(BanedUser banedUser);

    @Select("select count(*)>0 from BanedUser where User.userId=:userId")
        //是叫UserId吗？
    boolean isBanned(@QueryParam("userId") int userId);

}
