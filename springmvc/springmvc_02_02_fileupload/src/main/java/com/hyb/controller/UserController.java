package com.hyb.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 文件上传
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传................");

        //使用fileUpload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);

        //判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //进行判断，当前item是否是上传文件项
            if(item.isFormField()) {
                //说明普通表单项
            }else {
                //上传文件项
                //获取上传文件名称
                String fieldName = item.getName();
                //文件名称设置成唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fieldName = uuid + "_" + fieldName;
                System.out.println(fieldName);
                //完成文件上传
                item.write(new File(path,fieldName));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * springMVC文件上传
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC文件上传................");

        //使用fileUpload组件完成文件上传
        //上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);

        //判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()) {
            //创建该文件夹
            file.mkdirs();
        }


        //上传文件项
        //获取上传文件名称
        String fieldName = upload.getOriginalFilename();
        //文件名称设置成唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fieldName = uuid + "_" + fieldName;
        System.out.println(fieldName);
        //完成文件上传
        upload.transferTo(new File(path,fieldName));

        return "success";
    }

    /**
     * 跨服务器文件上传
     * @param upload
     * @return
     * @throws Exception
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3( MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传................");

        //定义上传文件服务器路径
        String path = "http://localhost:9091/uploads/";

        //上传文件项
        //获取上传文件名称
        String fieldName = upload.getOriginalFilename();
        //文件名称设置成唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fieldName = uuid + "_" + fieldName;
        System.out.println(fieldName);

        //创建客户端对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path + fieldName);
        //上传文件
        webResource.put(upload.getBytes());


        return "success";
    }
}
