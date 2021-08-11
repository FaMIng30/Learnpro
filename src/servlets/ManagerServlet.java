package servlets;

import bean.Page;
import bean.book;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import sun.misc.BASE64Encoder;
import webUtils.BookService;
import webUtils.JDBCutils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Encoder;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ManagerServlet",urlPatterns = "/ManagerServlet")
public class ManagerServlet extends BaseServlet {
//输出图书列表
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<book> bookList=BookService.queryBook();
        request.setAttribute("booklist",bookList);
        request.getRequestDispatcher("manager.jsp").forward(request,response);
    }

    protected void excel (HttpServletRequest request, HttpServletResponse response) throws IOException{
        List<book> bookList=BookService.queryBook();
        HSSFWorkbook workbook= new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet();
        Iterator<book> it=bookList.iterator();
       for(int i=0; it.hasNext();i++){
           book b=it.next();
           HSSFRow row=sheet.createRow(i);
           HSSFCell id=row.createCell(0);
           id.setCellValue(b.getID());
           HSSFCell name=row.createCell(1);
           name.setCellValue(b.getName());
           HSSFCell author =row.createCell(2);
           author.setCellValue(b.getAuthor());
           HSSFCell descrip =row.createCell(3);
           descrip.setCellValue(b.getDescrip());
//           Cell price=row.createCell(4);
//           price.setCellValue(b.getPrice());

        }
       response.setHeader("content-disposition","attachment");
        response.setContentType("application/vnd.ms-excel");
       workbook.write(response.getOutputStream());
    }

    protected void search (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String schname=request.getParameter("search");
        int pageNo= JDBCutils.parseInt(request.getParameter("pageNo"),1);
        int pageSize=JDBCutils.parseInt(request.getParameter("pageSize"),4);
        Page page=BookService.searchbyname(schname,pageNo,pageSize);
        request.setAttribute("page",page);
        page.setUrl("ManagerServlet?action=page");
        request.getRequestDispatcher("Client/BookHome.jsp").forward(request,response);


    }
//获取图书信息
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id=Integer.parseInt(request.getParameter("ID"));
       book book= BookService.queryByid(id);
       request.setAttribute("book",book);
       request.getRequestDispatcher("UpdateBook.jsp").forward(request,response);
    }
    //删除图书
    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
     Integer id=Integer.parseInt(request.getParameter("ID"));
     System.out.println(request.getParameter("ID"));
     BookService.deletes(id);
     request.getRequestDispatcher("ManagerServlet?action=page").forward(request,response);

    }
    //修改图书信息
    protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Integer id=Integer.parseInt(request.getParameter("ID"));
        String name= request.getParameter("name");
        String author= request.getParameter("author");
        String descrip= request.getParameter("descrip");
        int book= BookService.updateb(id,name,author,descrip);
        request.getRequestDispatcher("ManagerServlet?action=page").forward(request,response);
    }
    //添加图书
    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name= request.getParameter("name");
        String author= request.getParameter("author");
        String descrip= request.getParameter("descrip");
        BookService.add(name,author,descrip);
        request.getRequestDispatcher("ManagerServlet?action=page").forward(request,response);
    }
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    //获取图书的页码，和显示的数目
        System.out.println(Thread.currentThread().getName());
        int pageNo= JDBCutils.parseInt(request.getParameter("pageNo"),1);
        int pageSize=JDBCutils.parseInt(request.getParameter("pageSize"),4);
    //查询
        Page<book> page=BookService.page(pageNo,pageSize);
        page.setUrl("ManagerServlet?action=page");
    //数据存入request域中
        request.setAttribute("page",page);
    //请求转发
        request.getRequestDispatcher("manager.jsp").forward(request,response);
    }
}
