package top.yzlin.jx3strategystation.action;

import com.opensymphony.xwork2.ActionSupport;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.templates.CarouselItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class HomePage extends ActionSupport {

    private List<CarouselItem> carouselList;
    private List<BaseArticle> articleList;
    private Random random = new Random();

    public List<BaseArticle> getArticleList() {
        articleList = new ArrayList<>();
        BaseArticle baseArticles;
        for (int i = 0; i < 4; i++) {
            baseArticles = new BaseArticle();
            baseArticles.setImgPath("/static/img/carousel/" + (i + 1) + ".png");
            baseArticles.setTitle("实例" + random.nextInt(1000));
            articleList.add(baseArticles);
        }
        baseArticles = new BaseArticle();
        baseArticles.setTitle("实例" + random.nextInt(1000));
        articleList.add(baseArticles);
        return articleList;
    }

    public List<CarouselItem> getCarouselList() {
        if (carouselList == null) {
            CarouselItem[] carouselItems = new CarouselItem[4];
            for (int i = 0; i < carouselItems.length; i++) {
                carouselItems[i] = new CarouselItem();
                carouselItems[i].setImgPath("/static/img/carousel/" + (i + 1) + ".png");
                carouselItems[i].setTitle("实例" + (i + 1));
                carouselItems[i].setContent("实例" + (i + 1));
            }
            carouselList = Arrays.asList(carouselItems);
        }
        return carouselList;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
