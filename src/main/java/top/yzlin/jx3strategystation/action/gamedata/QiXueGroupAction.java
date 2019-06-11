package top.yzlin.jx3strategystation.action.gamedata;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.game.QiXueGroup;
import top.yzlin.jx3strategystation.service.QiXueGroupService;

import java.util.List;

@Component
public class QiXueGroupAction extends ActionSupport {
    private final QiXueGroupService qiXueGroupService;
    private String xinFaName;

    public QiXueGroupAction(QiXueGroupService qiXueGroupService) {
        this.qiXueGroupService = qiXueGroupService;
    }

    public void setXinFaName(String xinFaName) {
        this.xinFaName = xinFaName;
    }

    public List<QiXueGroup> getQiXueGroupList() {
        return qiXueGroupService.findQiXueGroupByXinFaName(xinFaName);
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
