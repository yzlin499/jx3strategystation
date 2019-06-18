package top.yzlin.jx3strategystation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yzlin.jx3strategystation.dao.SkillDAO;
import top.yzlin.jx3strategystation.entity.game.MenPai;
import top.yzlin.jx3strategystation.entity.game.Skill;
import top.yzlin.jx3strategystation.entity.game.XinFa;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SkillService {
    private final SkillDAO skillDAO;

    public SkillService(SkillDAO skillDAO) {

        this.skillDAO = skillDAO;
    }

    public MenPai findMenPaiByName(String name) {

        return skillDAO.findMenPaiByName(name);
    }

    public XinFa findXinFaByName(String name) {

        return skillDAO.findXinFaByName(name);
    }

    public List<Skill> findSkillByXinFaName(String xinFaName) {
        return skillDAO.findSkillByXinFaName(xinFaName);
    }

}
