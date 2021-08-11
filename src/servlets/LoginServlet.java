package servlets;

import bean.User;
import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import webUtils.CRUD;
import webUtils.JDBCutils;
import webUtils.LoginService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@WebServlet(name = "LoginServlet" ,urlPatterns = "/LoginServlet")
public class LoginServlet extends BaseServlet {

    protected void  registers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


        System.out.println("方法执行了");
        //从session域中获取验证码，谷歌验证码在生成验证码是就已经将验证码保存到session中所以可以直接获取
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);//123
        //删除后session域中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);//null
        System.out.println(token);
        //获取用户名和密码是否正确
        String username=null;
        String passwords =null;
        String tellphone=null;
        String gender=null;
        String logopath=null;
        String yzcode =null;
         String truename=null;

        System.out.println(yzcode);
        //如果正确则登录，否则提示用户名或密码错误

            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletContext servletContext = getServletContext();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
//            servletFileUpload.setHeaderEncoding("UTF-8");//
            //获取数据
            if (servletFileUpload.isMultipartContent(req)) {
                try {
                    List<FileItem> list = servletFileUpload.parseRequest(req);
                    for (FileItem fileitem : list) {
                        if (fileitem.isFormField()) {

                            if (fileitem.getFieldName().equals("username")) {
                                username = fileitem.getString("utf-8");
                            } else if (fileitem.getFieldName().equals("passwords")) {
                                passwords = fileitem.getString();
                            } else if (fileitem.getFieldName().equals("gender")) {
                                gender = fileitem.getString("utf-8");

                            } else if (fileitem.getFieldName().equals("tellphone")) {
                                tellphone = fileitem.getString();
                            } else if (fileitem.getFieldName().equals("yzcode")) {
                                yzcode = fileitem.getString();
                            } else if (fileitem.getFieldName().equals("truename")) {
                                truename = fileitem.getString("utf-8");
                            }
                        } else {
//                                    fileitem.getFieldName().equals("logopath");

                                logopath = fileitem.getName()==null? "default.jpg":fileitem.getName();
                            System.out.println(logopath+"----------------------");

                            String filepath = "C://Users//Tomorrow//eclipse-workspace//Learnpro//web//images//" + fileitem.getName();
                            File file = new File(filepath);
                            if(file.exists()){
                                System.out.println("有重复的");
                            }else {
                                fileitem.write(file);
                            }
                        }
                    }
                } catch (FileUploadException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


                        //保存数据
                        if (token != null && token.equals(yzcode)) {//检测验证码的正确性
                            System.out.println(truename+"\t"+passwords+"\t"+gender+"\t"+tellphone+"\t"+logopath);
                            if (LoginService.existOrnot(username, tellphone)) {//检测用户名和电话是否重复
                                LoginService.register(username, tellphone, passwords, gender, logopath, truename);
                                System.out.println("数据插入成功");
                            req.getRequestDispatcher("Login.jsp").forward(req,resp);
                        }

                        }else {
                          req.getRequestDispatcher("registers.jsp").forward(req,resp);
                        }



            }




    protected void exitsUsername (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //System.out.println("数据已接收");
        String username = req.getParameter("username");
        Boolean existusername = LoginService.existUsername(username);
        Map<String, Boolean> maps = new HashMap<>();
        maps.put("existusername", existusername);
        resp.getWriter().write(new Gson().toJson(maps));
    }     //   System.out.println("数据已发送");

    protected void exitsTelphone (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       System.out.println("电话核查中");
        String tellphone = req.getParameter("tellphone");
        Boolean existtellphone = LoginService.existTellphone(tellphone);
        Map<String, Boolean> maps = new HashMap<>();
        maps.put("existtellphone", existtellphone);
        resp.getWriter().write(new Gson().toJson(maps));
       // System.out.println("数据已发送");
    }
    protected void Login (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("信息核查中");
        String username=req.getParameter("username");
        String passwords = req.getParameter("passwords");
       User user  = LoginService.queryLogin(username,passwords);
       String logopath=user.getLogopath();
        Boolean  loginofno=user!=null;
        HttpSession session=req.getSession();
        Cookie cookie=new Cookie("username",username);
        resp.addCookie(cookie);
        if (loginofno){
            session.setAttribute("logo",logopath);
            session.setAttribute("username",username);
            resp.sendRedirect("BookHome.jsp");}
        else{
            req.setAttribute("user","密码错误");//用于提示密码错误
            req.getRequestDispatcher("Login.jsp").forward(req,resp);
        }
        // System.out.println("数据已发送");
    }
}