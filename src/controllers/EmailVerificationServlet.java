package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;


@WebServlet("/evfc.do")
public class EmailVerificationServlet  extends HttpServlet{
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
        String email = request.getParameter("email");
        String vfcode = request.getParameter("vfcode");

        String nextPage = "error.jsp"; 
        
        if(User.verificationOfEmail(email,vfcode)){
            nextPage = "loginLibrary.jsp";

        }

        request.getRequestDispatcher(nextPage).forward(request,response);
    }
    
}
