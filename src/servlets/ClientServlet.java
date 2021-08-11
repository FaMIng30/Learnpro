package servlets;

import bean.Page;
import bean.book;
import webUtils.BookService;
import webUtils.JDBCutils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClientServlet" ,urlPatterns = "/ClientServlet")
public class ClientServlet extends BaseServlet{
    protected void page (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取图书的页码，和显示的数目
        int pageNo= JDBCutils.parseInt(request.getParameter("pageNo"),1);
        int pageSize=JDBCutils.parseInt(request.getParameter("pageSize"),8);
        //查询

        Page<book> page= BookService.page(pageNo,pageSize);
        //数据存入request域中
        page.setUrl("ClientServlet?action=page");
        request.setAttribute("page",page);
        //请求转发
        request.getRequestDispatcher("Client/BookHome.jsp").forward(request,response);
    }


}
