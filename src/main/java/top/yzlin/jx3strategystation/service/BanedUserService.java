package top.yzlin.jx3strategystation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.yzlin.jx3strategystation.dao.BanedUserDAO;
import top.yzlin.jx3strategystation.entity.user.BanedUser;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class BanedUserService {
    private final BanedUserDAO banedUserDAO;

    @Autowired
    public BanedUserService(BanedUserDAO banedUserDAO) {
        this.banedUserDAO = banedUserDAO;
    }

    public List<BanedUser> findBanedUserList() {
        return banedUserDAO.findBanedUserList();
    }

    public void deleteBanedUserByBanedUserId(int id) {
        banedUserDAO.deleteBanedUserByBanedUserId(id);
    }

    public int saveBanedUser(BanedUser banedUser) {
        return banedUserDAO.saveBanedUser(banedUser);
    }

    public boolean isBanned(int userId) {
        return banedUserDAO.isBanned(userId);
    }
}
