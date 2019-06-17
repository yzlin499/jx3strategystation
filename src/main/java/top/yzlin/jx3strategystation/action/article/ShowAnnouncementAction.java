package top.yzlin.jx3strategystation.action.article;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;

@Component
public class ShowAnnouncementAction extends ActionSupport {
    private String ActionName = "Announcement";

    public String getAActionName() {
        return ActionName;
    }

    public String execute() {
        return SUCCESS;
    }

}
