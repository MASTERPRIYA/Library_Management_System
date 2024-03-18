package controllers;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Librarian;
import models.User;

@WebServlet("/loginLibrarian.do")
public class LoginLibrarianServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
        request.getRequestDispatcher("loginLibrarian.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        System.out.println(email+"----------------------emailLibrarians");
        String password = request.getParameter("password");
        System.out.println(password+"-------------------passwordLibrarians");

        Librarian librarian = new Librarian(email,password);
        librarian.updateStatusId(email); // update statusId to 1.

        int statusId = librarian.signInLibrarian();
       
        System.out.println(statusId+"-----------------Librarians------------------------------");
        String nextpage = "loginLibrarian.jsp";

        switch (statusId) {
            case 1:
                if(librarian.getUserType().getUserTypeId() == 2){
                    System.out.println(librarian+"+++++++++++++user+++Librarians+++++++++++++++++++");
                    session.setAttribute("librarian", librarian);
                    nextpage="librarianView.jsp";
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