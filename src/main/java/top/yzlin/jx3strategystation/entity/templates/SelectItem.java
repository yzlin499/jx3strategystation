package top.yzlin.jx3strategystation.entity.templates;

import java.util.Arrays;

public class SelectItem {
    private String name;
    private String[] children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getChildren() {
        return children;
    }

    public void setChildren(String[] children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SelectItem{" +
                "name='" + name + '\'' +
                ", children=" + Arrays.toString(children) +
                '}';
    }
}
