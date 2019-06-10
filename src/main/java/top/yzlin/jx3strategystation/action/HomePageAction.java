package top.yzlin.jx3strategystation.action;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.entity.community.BaseArticle;
import top.yzlin.jx3strategystation.entity.templates.CarouselItem;
import top.yzlin.jx3strategystation.service.ArticleService;

import java.util.Arrays;
import java.util.List;

@Component
public class HomePageAction extends ActionSupport {
    private final ArticleService articleService;
    private List<CarouselItem> carouselList;
    private int page = 0;

    public HomePageAction(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<BaseArticle> getArticleList() {
        List<BaseArticle> article = articleService.findArticle(page);
        page = 0;
        return article;
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

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
