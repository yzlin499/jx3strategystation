package top.yzlin.jx3strategystation.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.io.FileUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ResourceUtils;
import top.yzlin.jx3strategystation.entity.templates.SelectItem;
import top.yzlin.jx3strategystation.tools.CmdUtils;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("top.yzlin.jx3strategystation")
@PropertySource("classpath:config.properties")
@EnableTransactionManagement
public class MainConfig {
    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    @Profile("dev")
    public DataSource dataSource() throws PropertyVetoException, IOException {
        String dbpath = environment.getProperty(CmdUtils.getGitUserName() + ".sqlite.dbpath", "classpath:db/skill.db");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("org.sqlite.JDBC");
        System.out.println(ResourceUtils.getFile(dbpath).getAbsolutePath());
        dataSource.setJdbcUrl("jdbc:sqlite:" + ResourceUtils.getFile(dbpath).getAbsolutePath());
        return dataSource;
    }

    @Bean
    @Profile("prod")
    public DataSource prodDataSource(@Value("${sqlite.dbpath}") Resource dbPath) throws PropertyVetoException, IOException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("org.sqlite.JDBC");
        dataSource.setJdbcUrl("jdbc:sqlite:" + dbPath.getFile().getAbsolutePath());
        return dataSource;
    }

    @Bean
    LocalSessionFactoryBean sessionFactory(DataSource dataSource,
                                           @Value("${hibernate.dialect}") String dialect) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hbm2ddl.auto", "update");
        sessionFactory.setHibernateProperties(properties);
        sessionFactory.setPackagesToScan("top.yzlin.jx3strategystation.entity");
        return sessionFactory;
    }

    @Bean
    HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }

    @Bean
    public SelectItem[] district(@Value("${district.data}") Resource district) throws PropertyVetoException, IOException {
        return jsonToSelectItem(district);
    }

    @Bean
    public SelectItem[] strategy(@Value("${strategy.data}") Resource strategy) throws PropertyVetoException, IOException {
        return jsonToSelectItem(strategy);
    }

    private SelectItem[] jsonToSelectItem(Resource jsonResource) throws IOException {
        JSONObject json = JSON.parseObject(FileUtils.readFileToString(jsonResource.getFile(), "UTF-8"));
        return json.keySet().stream().map(e -> {
            SelectItem selectItem = new SelectItem();
            selectItem.setName(e);
            selectItem.setChildren(json.getJSONArray(e).stream().map(Object::toString).toArray(String[]::new));
            return selectItem;
        }).toArray(SelectItem[]::new);
    }
}
