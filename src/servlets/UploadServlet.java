package servlets;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "UploadServlet",urlPatterns = "/UploadServlet")
public class UploadServlet extends BaseServlet {


    protected void upload (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        FileItemFactory fileItemFactory = new DiskFileItemFactory();
        ServletContext servletContext = getServletContext();
        ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
        if (servletFileUpload.isMultipartContent(request)) {//是否多段的方式上传
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);//解析表单项为FileItem对象
                for (FileItem fileItem : list) {//遍历对象
                    if (fileItem.isFormField()) {//是否为普通类型
                        System.out.println(fileItem.getFieldName());//input中的name属性值
                        System.out.println(fileItem.getString());//value值
                    } else {
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getName());//文件名
                        String filepath = "C://Users//Tomorrow//eclipse-workspace//Learnpro//web//images//"+ fileItem.getName();
                        String mime = servletContext.getMimeType(filepath);//文件的类型
                        System.out.println(mime);
                        File file = new File(filepath);
//                        if (file.exists()) {
//                            UUID uuid = UUID.randomUUID();//生成一个不重复的数
//                            System.out.println(uuid);
//                            file = new File(filepath);
//                        }

                        fileItem.write(file);//写入文件到磁盘中
                        request.getRequestDispatcher("BookHome.jsp").forward(request, response);
                    }

                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void download (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ServletContext servletContext=getServletContext();
        String filename="枫.jpg";
        if (request.getHeader("User-Agent").contains("firefox")){//是否为火狐浏览器，  谷歌，IE为URL编码，火狐用Base64编码
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(filename,"UTF-8"));//设置响应头，attachment表示附件用于下载
       }else{
            response.setHeader("content-disposition","attachment;filename==?UTF-8?B?"+new BASE64Encoder().encode(filename.getBytes("UTF-8"))+"?=");
        }
        InputStream inputStream=new FileInputStream("D://"+filename);//读取文件
        OutputStream outputStream=response.getOutputStream();//响应输出流
        IOUtils.copy(inputStream,outputStream);




    }
}
