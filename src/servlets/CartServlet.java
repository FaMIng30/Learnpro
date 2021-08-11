package servlets;

import bean.Cart;
import bean.Cartiterm;
import bean.book;
import com.google.gson.Gson;
import webUtils.BookService;
import webUtils.JDBCutils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet",urlPatterns = "/CartServlet")
public class CartServlet extends BaseServlet {
    protected void addCart (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = JDBCutils.parseInt(request.getParameter("ID"), 0);
        book books = BookService.queryByid(id);
        Cartiterm cartiterm = new Cartiterm(books.getID(), books.getName(), 1, books.getPrice(), books.getPrice());
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        System.out.println(cart.getTotalPrice()+"22222222222222222222222222");
        cart.addIterm(cartiterm);
        System.out.println(cart.getTotalPrice()+"3333333333333333333333333");
        System.out.println( request.getSession());
      response.getWriter().write(new Gson().toJson(cartiterm.getItermname()));
    }

    protected void deliterm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = JDBCutils.parseInt(request.getParameter("ID"), 0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.delIterm(id);
            request.getRequestDispatcher("ShoppingCart.jsp").forward(request, response);
        }
    }

    protected void updatecounts (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = JDBCutils.parseInt(request.getParameter("ID"), 0);
        int counts=JDBCutils.parseInt(request.getParameter("countss"), 1);
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        if (cart!=null){
            cart.updateCount(id,counts);
            Cartiterm cartiterm=cart.getCartiterm().get(id);
            response.getWriter().write(new Gson().toJson(cartiterm));

        }
        }
        }