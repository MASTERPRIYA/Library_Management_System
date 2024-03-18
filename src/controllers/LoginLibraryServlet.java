package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import models.UserType;
import models.City;
import models.Librarian;



@WebServlet("/loginLibrary.do")
public class LoginLibraryServlet extends HttpServlet{
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
        request.getRequestDispatcher("loginLibrary.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException ,ServletException{
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        

        User user = new User(email, password);
       
        int flag = user.signinuser();
        System.out.println(flag+"*******id*****Library*****");
        String nextpage = "loginLibrary.jsp";

        switch (flag) {
            case 1:
                if(user.getUserType().getUserTypeId()==1){
                    System.out.println(user+"+++++++++++++user+++Library+++++++++++++++++++");
                    session.setAttribute("user", user);
                    ArrayList<Librarian> librarians = Librarian.collectAllLibrarians(2);            
                    session.setAttribute("librarians", librarians);
                    nextpage = "tableLibrary.jsp";
                    break;
                }else{
                    nextpage="error.jsp";
                } 
                break;
            case -1:
                session.setAttribute("password_email_err", "Incorrect password or email not exist");  
                break;
            case 3:
                session.setAttribute("closed_err", "Your account is closed.To activate your account <link>");  
                break;    
            case 4:
                session.setAttribute("blocked_err", "Sorry...your account is blocked");  
                break;
            case 5:
                session.setAttribute("pending_err", "Your request is pending");  
                break;    
                        
                    
        }
        
        request.getRequestDispatcher(nextpage).forward(request, response);
           

    }

    
}