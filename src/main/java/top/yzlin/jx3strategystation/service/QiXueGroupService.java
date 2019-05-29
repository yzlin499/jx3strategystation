package top.yzlin.jx3strategystation.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yzlin.jx3strategystation.dao.QiXueGroupDAO;
import top.yzlin.jx3strategystation.entity.game.QiXueGroup;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class QiXueGroupService {
    private final QiXueGroupDAO qiXueGroupDAO;

    public QiXueGroupService(QiXueGroupDAO qiXueGroupDAO) {
        this.qiXueGroupDAO = qiXueGroupDAO;
    }

    public List<QiXueGroup> findQiXueGroup() {
        return qiXueGroupDAO.findQiXueGroup();
    }
}
