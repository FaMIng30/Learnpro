package webUtils;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;

public class Service {
    public static  boolean  login(String sql, HttpServletRequest req ,Object...param){
        String username=req.getParameter("username");
        Object name=CRUD.scalaquery("select username from USERs where username=?",username);
         return name==null;

    }
}
