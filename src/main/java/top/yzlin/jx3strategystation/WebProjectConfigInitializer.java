package top.yzlin.jx3strategystation;


import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import top.yzlin.jx3strategystation.config.MainConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

public class WebProjectConfigInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
        container.setInitParameter("spring.profiles.active", "dev");
        FilterRegistration.Dynamic struts2 = container.addFilter("struts2", StrutsPrepareAndExecuteFilter.class);
        struts2.addMappingForUrlPatterns(null, false, "/*");
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(MainConfig.class);
        container.addListener(new ContextLoaderListener(rootContext));
    }
}
