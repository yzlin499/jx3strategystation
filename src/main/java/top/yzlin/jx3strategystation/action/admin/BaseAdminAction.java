package top.yzlin.jx3strategystation.action.admin;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAdminAction extends ActionSupport {
    private String listView;

    public String getListView() {
        return listView;
    }

    public void setListView(String listView) {
        this.listView = listView;
    }
}
