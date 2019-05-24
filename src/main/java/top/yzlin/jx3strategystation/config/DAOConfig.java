package top.yzlin.jx3strategystation.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.yzlin.jx3strategystation.dao.*;
import top.yzlin.jx3strategystation.database.DAOInvocationHandler;

import java.lang.reflect.Proxy;

@Configuration
public class DAOConfig {

    @Bean
    public ReviewArticleDAO reviewArticleDAO(@Autowired SessionFactory sessionFactory) {
        return createDAO(ReviewArticleDAO.class, sessionFactory);
    }

    @Bean
    public QiXueGroupDAO qiXueGroupDAO(@Autowired SessionFactory sessionFactory) {
        return createDAO(QiXueGroupDAO.class, sessionFactory);
    }

    @Bean
    public ArticleDAO articleDAO(@Autowired SessionFactory sessionFactory) {
        return createDAO(ArticleDAO.class, sessionFactory);
    }

    @Bean
    public UserDAO userDAO(@Autowired SessionFactory sessionFactory) {
        return createDAO(UserDAO.class, sessionFactory);
    }

    @Bean
    public CommentDAO commentDAO(@Autowired SessionFactory sessionFactory) {
        return createDAO(CommentDAO.class, sessionFactory);
    }

    private <T> T createDAO(Class<T> daoInterface, SessionFactory sessionFactory) {
        return (T) Proxy.newProxyInstance(
                daoInterface.getClassLoader(),
                new Class[]{daoInterface},
                new DAOInvocationHandler(daoInterface, sessionFactory));
    }
}
