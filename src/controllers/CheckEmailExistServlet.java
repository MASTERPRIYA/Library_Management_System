package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import models.User;

@WebServlet("/check_email_exist.do")
public class CheckEmailExistServlet  extends HttpServlet{
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException{
        String email = request.getParameter("email");
        System.out.println(email);
        
        boolean flag=false;

        if(User.CheckEmailExist(email)){
            System.out.println(email);
            flag=true;
            System.out.println(flag);
        }

        response.getWriter().print(flag);
    }
    
}
