package top.yzlin.jx3strategystation.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import top.yzlin.jx3strategystation.entity.templates.SelectItem;
import top.yzlin.jx3strategystation.tools.CmdUtils;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;

@Configuration
@PropertySource("classpath:config.properties")
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
    public SelectItem[] district(@Value("${district.data}") Resource district) throws PropertyVetoException, IOException {
        return jsonToSelectItem(district);
    }

    @Bean
    public SelectItem[] strategy(@Value("${strategy.data}") Resource strategy) throws PropertyVetoException, IOException {
        return jsonToSelectItem(strategy);
    }

    private SelectItem[] jsonToSelectItem(Resource jsonResource) throws IOException {
        JSONObject json=JSON.parseObject(FileUtils.readFileToString(jsonResource.getFile(),"UTF-8"));
        return json.keySet().stream().map(e->{
            SelectItem selectItem =new SelectItem();
            selectItem.setName(e);
            selectItem.setChildren(json.getJSONArray(e).stream().map(Object::toString).toArray(String[]::new));
            return selectItem;
        }).toArray(SelectItem[]::new);
    }
}
