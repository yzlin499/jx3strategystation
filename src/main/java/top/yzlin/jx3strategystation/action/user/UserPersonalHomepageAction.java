package top.yzlin.jx3strategystation.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.user.User;
import top.yzlin.jx3strategystation.service.ArticleService;
import top.yzlin.jx3strategystation.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class UserPersonalHomepageAction extends ActionSupport implements SessionAware {
    private UserService userService;
    private String nnN;
    private String nuN;
    private String nM;
    private final ArticleService articleService;
    private Map<String, Object> session;
    private boolean upDateSuccess;

    public UserPersonalHomepageAction(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<BaseArticle> getArticleList() {
        return articleService.findArticleByUserId(((User) session.get("user")).getUserId());
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setNnN(String nnN) {
        this.nnN = nnN;
    }

    public void setNuN(String nuN) {
        this.nuN = nuN;
    }

    public void setnM(String nM) {
        this.nM = nM;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isUpDateSuccess() {
        return upDateSuccess;
    }

    @Override
    public String execute() throws Exception {
        User user = (User) session.get("user");
        if (!Objects.equals(user.getNickName(), nnN) && nnN != null) {
            user.setNickName(nnN);
            userService.updateUser(user);
            if (!Objects.equals(user.getUserName(), nuN) && nuN != null) {
                user.setUserName(nuN);
                userService.updateUser(user);
                if (!Objects.equals(user.getMail(), nM) || nM != null) {
                    user.setMail(nM);
                    userService.updateUser(user);
                    upDateSuccess = true;
                } else {
                    upDateSuccess = false;
                }
                return SUCCESS;
            }
        }
        return SUCCESS;
    }
}
