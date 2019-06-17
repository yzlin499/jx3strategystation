package top.yzlin.jx3strategystation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yzlin.jx3strategystation.dao.QiXueGroupDAO;
import top.yzlin.jx3strategystation.entity.game.MenPai;
import top.yzlin.jx3strategystation.entity.game.QiXueGroup;
import top.yzlin.jx3strategystation.entity.game.Skill;
import top.yzlin.jx3strategystation.entity.game.XinFa;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class QiXueGroupService {
    private final QiXueGroupDAO qiXueGroupDAO;

    public QiXueGroupService(QiXueGroupDAO qiXueGroupDAO) {
        this.qiXueGroupDAO = qiXueGroupDAO;
    }

    public List<MenPai> findMenPai() {
        return qiXueGroupDAO.findMenPai();
    }

    public MenPai findMenPaiByName(String name) {
        return qiXueGroupDAO.findMenPaiByName(name);
    }

    public XinFa findXinFaByName(String name) {
        return qiXueGroupDAO.findXinFaByName(name);
    }


    public List<QiXueGroup> findQiXueGroupByXinFaName(String xinFaName) {
        return qiXueGroupDAO.findQiXueGroupByXinFaName(xinFaName);
    }

    public List<Skill> findSkillListByXinFaName(String name) {
        return qiXueGroupDAO.findSkillListByXinFaName(name);
    }
}
