package top.yzlin.jx3strategystation.action.gamedata;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.game.QiXueGroup;
import top.yzlin.jx3strategystation.service.QiXueGroupService;

import java.util.List;

@Component
public class QiXueGroupAction extends BaseGameDataAction {
    private final QiXueGroupService qiXueGroupService;

    public QiXueGroupAction(QiXueGroupService qiXueGroupService) {
        this.qiXueGroupService = qiXueGroupService;
    }

    public List<QiXueGroup> getQiXueGroupList() {
        return qiXueGroupService.findQiXueGroupByXinFaName(xinFaName);
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
