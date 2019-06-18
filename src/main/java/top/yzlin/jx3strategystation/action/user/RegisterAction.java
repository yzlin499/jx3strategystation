package top.yzlin.jx3strategystation.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.UserService;

import java.util.Optional;
import java.util.regex.Pattern;

@Component
public class RegisterAction extends ActionSupport {
    private Pattern userNamePattern = Pattern.compile("^[a-zA-Z]\\w{4,16}$");
    private Pattern passwordPattern = Pattern.compile("^\\w{4,10}$");
    private Pattern niceNamePattern = Pattern.compile("^[\\u4e00-\\u9fa5a-zA-Z0-9]{2,6}$");
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
        if (userNamePattern.matcher(Optional.ofNullable(user.getUserName()).orElse("")).find() &&
                passwordPattern.matcher(Optional.ofNullable(user.getPassword()).orElse("")).find() &&
                niceNamePattern.matcher(Optional.ofNullable(user.getNickName()).orElse("")).find()) {
            if (userService.isExistUser(user.getUserName())) {
                userId = -1;
            } else {
                user.setPortrait("/static/img/test/testHead.jpg");
                userId = userService.saveUser(user);
            }
        } else {
            userId = -1;
        }
        return SUCCESS;
    }
}
