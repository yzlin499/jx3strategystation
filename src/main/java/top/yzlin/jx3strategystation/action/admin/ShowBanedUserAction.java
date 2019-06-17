package top.yzlin.jx3strategystation.action.admin;

import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.user.BanedUser;
import top.yzlin.jx3strategystation.service.BanedUserService;

import java.util.List;

@Component
public class ShowBanedUserAction extends BaseAdminAction {

    private BanedUserService banedUserService;

    public ShowBanedUserAction(BanedUserService banedUserService) {
        this.banedUserService = banedUserService;
    }

    public List<BanedUser> getBanedUserList() {
        return banedUserService.findBanedUserList();
    }

}
