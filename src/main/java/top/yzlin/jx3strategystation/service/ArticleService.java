package top.yzlin.jx3strategystation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yzlin.jx3strategystation.dao.ArticleDAO;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;

import javax.transaction.Transactional;

@Service
public class ArticleService {
    private ArticleDAO articleDAO;

    @Autowired
    public void setArticleDAO(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Transactional(rollbackOn = Exception.class)
    public void saveArticleDAO(BaseArticle baseArticle) {
        articleDAO.saveArticle(baseArticle);
    }
}
