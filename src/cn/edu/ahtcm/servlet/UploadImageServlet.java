package cn.edu.ahtcm.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@WebServlet( "/UploadImageServlet")
public class UploadImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject obj =new JSONObject();
        //文件保存路径
        String  savePath = this.getServletContext().getRealPath("/upload");
        File saveFileDir =new File(savePath);
         if (!saveFileDir.exists()){
             saveFileDir.mkdirs();

         }
         //临时文件保存目录
        String tmpPath =this.getServletContext().getRealPath("/uoload/tmp");
         File tmpFile = new File(tmpPath);
         if (!tmpFile.exists())
         {
             tmpFile.mkdirs();
         }
        try {
        DiskFileItemFactory factory = new DiskFileItemFactory();
         factory.setSizeThreshold(1024*10);
         factory.setRepository(tmpFile);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(1024*1024*3);
        List<FileItem> items =upload.parseRequest(request);
        Iterator<FileItem> iter = items.iterator();
            String message="";
        while(iter.hasNext()){
            FileItem item =iter.next();
            String filename = item.getName();
            long filesize = item.getSize();
            if (!item.isFormField()){
                //检查文件大小
                if (item.getSize()>1024*1024*3){
                    message =message+"文件"+filename+upload.getFileSizeMax();
                    obj.put("error",1);
                    obj.put("message",message);
                }else{
                    //获取文件的托展名
                    String fileExt = filename.substring(filename.lastIndexOf(".")+1).toLowerCase();
                    //文件名重写
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                    String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000)+"." + fileExt;
                    File uploadFile = new File(savePath,newFileName);
                    item.write(uploadFile);
                    String url = "/upload/" + newFileName;
                    obj.put("error",0);
                    obj.put("url",url);
                }
            }

        }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(obj);
        response.getWriter().print(obj);

    }

}
