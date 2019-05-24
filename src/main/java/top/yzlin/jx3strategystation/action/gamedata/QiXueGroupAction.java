package top.yzlin.jx3strategystation.action.gamedata;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.game.QiXueGroup;
import top.yzlin.jx3strategystation.service.QiXueGroupService;

import java.util.List;

@Component
public class QiXueGroupAction extends ActionSupport {

    private final QiXueGroupService qiXueGroupService;

    public QiXueGroupAction(QiXueGroupService qiXueGroupService) {
        this.qiXueGroupService = qiXueGroupService;
    }

    public List<QiXueGroup> getQiXueGroupList() {
        return qiXueGroupService.findQiXueGroup();
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
