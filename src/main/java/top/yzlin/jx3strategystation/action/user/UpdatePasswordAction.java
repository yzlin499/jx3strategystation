package top.yzlin.jx3strategystation.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.UserService;

import java.util.Map;
import java.util.Objects;

@Component
public class UpdatePasswordAction extends ActionSupport implements SessionAware {

    private String oldPassword;
    private String newPassword;
    private UserService userService;
    private Map<String, Object> session;
    private boolean upDateSuccess;

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        if (Objects.equals(user.getPassword(), oldPassword)) {
            user.setPassword(newPassword);
            userService.updatePassword(user);
            upDateSuccess = true;
            session.put("user", null);
        } else {
            upDateSuccess = false;
        }
        return SUCCESS;
    }
}
