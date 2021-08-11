package servlets;

import bean.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxServlet",urlPatterns = "/AjaxServlet")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("UTF-8" );


    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
