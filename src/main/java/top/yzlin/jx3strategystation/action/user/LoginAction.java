package top.yzlin.jx3strategystation.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.UserService;

import java.util.Map;

@Component
public class LoginAction extends ActionSupport implements SessionAware {
    private final UserService userService;
    private Map<String, Object> session;
    private User user;
    private boolean loginStatic;

    public LoginAction(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoginStatic() {
        return loginStatic;
    }

    @Override
    public String execute() {
        if ((user = userService.findUserByUserNameAndPassword(user)) == null) {
            loginStatic = false;
        } else {
            loginStatic = true;
            session.put("user", user);
        }
        return SUCCESS;
    }

    public String logOut() {
        session.put("user", null);
        return SUCCESS;
    }
}
