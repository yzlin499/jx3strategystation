package top.yzlin.jx3strategystation.action.gamedata;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.game.Skill;
import top.yzlin.jx3strategystation.service.SkillService;

import java.util.List;

@Component
public class SkillAction extends BaseGameDataAction {
    private final SkillService skillService;

    public SkillAction(SkillService skillService) {
        this.skillService = skillService;
    }

    public List<Skill> getSkillList() {
        return skillService.findSkillByXinFaName(getXinFaName());
    }
}
