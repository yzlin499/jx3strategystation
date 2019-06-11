package top.yzlin.jx3strategystation.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.StrutsUploadedFile;
import org.springframework.stereotype.Component;
import top.yzlin.jx3strategystation.tools.Md5Utils;

import java.io.File;
import java.io.IOException;

@Component
public class UpdateImg extends ActionSupport {
    private int uploaded;
    private String url;

    private StrutsUploadedFile upload;
    private String uploadFileName;

    public void setUpload(StrutsUploadedFile upload) {
        this.upload = upload;
    }


    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public int getUploaded() {
        return uploaded;
    }

    public String getUrl() {
        return url;
    }


    @Override
    public String execute() {

        //获取要保存文件夹的物理路径(绝对路径)
        String realPath = ServletActionContext.getServletContext().getRealPath("/upload/image");
        File file = new File(realPath);
        System.out.println(file.getAbsolutePath());

        //测试此抽象路径名表示的文件或目录是否存在。若不存在，创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
        if (!file.exists()) {
            file.mkdirs();
        }
        uploadFileName = (System.currentTimeMillis() / 2000) +
                Md5Utils.getMd5(uploadFileName) +
                uploadFileName.substring(uploadFileName.lastIndexOf('.'));
        try {
            //保存文件
            FileUtils.copyFile(upload.getContent(), new File(file, uploadFileName));
            url = "/upload/image/" + uploadFileName;
            uploaded = 1;
        } catch (IOException e) {
            e.printStackTrace();
            uploaded = 0;
        }
        return SUCCESS;
    }

}
