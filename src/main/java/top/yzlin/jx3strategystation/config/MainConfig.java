package top.yzlin.jx3strategystation.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

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
    public String data(@Value("${sqlite.dbpath}") Resource dbPath) throws PropertyVetoException, IOException {
        return dbPath.getFile().getAbsolutePath();
    }
}
