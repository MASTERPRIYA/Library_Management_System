package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

import java.io.IOException;


@WebServlet("/changePassword.do")
public class ChangePasswordServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        request.getRequestDispatcher("loginLibrarian.jsp").forward(request, response);
    } 
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{ 
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        
        if(email !=null && !email.isEmpty() && password!=null && !password.isEmpty()){
            User.changePassword(email, password);
            System.out.println(email);
            System.out.println(password+"++++++++++++++++++++NEW PASSWORD+++++++++++++++++++++");
            System.out.println("password changed successfully");
        } else{
            System.out.println("Incorrect");
        }

      response.sendRedirect("loginLibrarian.jsp");
    }

}