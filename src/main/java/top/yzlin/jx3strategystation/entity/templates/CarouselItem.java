package top.yzlin.jx3strategystation.entity.templates;

import java.util.Objects;

public class CarouselItem {
    private String imgPath;
    private String title="";
    private String content="";

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
