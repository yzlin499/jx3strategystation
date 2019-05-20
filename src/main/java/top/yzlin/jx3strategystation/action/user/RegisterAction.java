package top.yzlin.jx3strategystation.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.UserService;

@Component
public class RegisterAction extends ActionSupport {
    private UserService userService;
    private User user;
    private int userId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        userId = userService.saveUser(user);
        return SUCCESS;
    }
}
