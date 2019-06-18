package top.yzlin.jx3strategystation.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.user.Admin;

import javax.servlet.http.HttpSession;

@Component
public class AdminInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }


    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        if (session.getAttribute("user") != null && session.getAttribute("user") instanceof Admin) {
            return actionInvocation.invoke();
        } else {
            return "login";
        }
    }
}
