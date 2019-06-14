package top.yzlin.jx3strategystation.action.gamedata;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.game.Skill;
import top.yzlin.jx3strategystation.service.SkillService;

import java.util.List;

@Component
public class SkillAction extends ActionSupport {
    private final SkillService skillService;
    private String xinFaName;

    public SkillAction(SkillService skillService) {
        this.skillService = skillService;
    }

    public void setXinFaName(String xinFaName) {
        this.xinFaName = xinFaName;
    }

    public List<Skill> getSkillList() {
        return skillService.findSkillByXinFaName(xinFaName);
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
