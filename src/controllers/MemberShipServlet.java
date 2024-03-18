package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Membership;

import java.io.IOException;

@WebServlet("/memberShip.do")
public class MemberShipServlet extends HttpServlet {
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();

       // String nextPage="loginCandidate.jsp";
        String email= request.getParameter("email");
      
      
        Membership membership= new Membership();
        membership.memberShip(email);
                    
        
    }
    
}
