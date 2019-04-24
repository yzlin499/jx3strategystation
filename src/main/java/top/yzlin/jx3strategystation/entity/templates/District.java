package top.yzlin.jx3strategystation.entity.templates;

import java.util.Arrays;

public class District {
    private String name;
    private String[] services;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getServices() {
        return services;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", services=" + Arrays.toString(services) +
                '}';
    }
}
