package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;

@WebServlet(name = "BaseServlet",urlPatterns = "/BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
       doPost(req,resp);
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
               request.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=UTF-8");
                   String action=request.getParameter("action");
                    if (action==null ||action.isEmpty()){
                        System.out.println("action为空");}
                    else{
                        try {
                            //Class clazz=this.getClass();只能得到子类的属性
                            //Class clazz = Class.forName("test.Person");只能得到父类的属性
                            Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
                            method.invoke(this, request,response);
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }

    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
             doPost(request,response);
    }
}
