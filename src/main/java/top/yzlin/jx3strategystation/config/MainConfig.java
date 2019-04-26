package top.yzlin.jx3strategystation.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import top.yzlin.jx3strategystation.entity.templates.SelectItem;

import java.beans.PropertyVetoException;
import java.io.IOException;

@Configuration
public class MainConfig {

//    @Bean
//    public ComboPooledDataSource dataSource(@Value("${sqlite.dbpath}")Resource dbPath) throws PropertyVetoException, IOException {
//        ComboPooledDataSource dataSource=new ComboPooledDataSource();
//        dataSource.setDriverClass("org.sqlite.JDBC");
//        dataSource.setJdbcUrl("jdbc:sqlite:"+dbPath.getFile().getAbsolutePath());
//        return dataSource;
//    }

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
