package top.yzlin.jx3strategystation.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.yzlin.jx3strategystation.dao.ArticleDAO;
import top.yzlin.jx3strategystation.database.DAOInvocationHandler;

import java.lang.reflect.Proxy;

@Configuration
public class DAOConfig {

    @Bean
    public ArticleDAO articleDAO(@Autowired SessionFactory sessionFactory) {
        return createDAO(ArticleDAO.class, sessionFactory);
    }


    private <T> T createDAO(Class<T> daoInterface, SessionFactory sessionFactory) {
        return (T) Proxy.newProxyInstance(
                daoInterface.getClassLoader(),
                new Class[]{daoInterface},
                new DAOInvocationHandler(daoInterface, sessionFactory));
    }
}