package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import models.User;

@WebServlet("/check_email_duplicacy.do")
public class CheckEmailDuplicacyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException{
        String email = request.getParameter("email");
        boolean flag = false;

        if(User.checkEmailDuplicacy(email)){
            flag=true;
        }

        response.getWriter().print(flag);
    }
    
}
