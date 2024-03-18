package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Edition;
import models.Candidate;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/loginCandidate.do")
public class LoginCandidateServlet extends HttpServlet{
    public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
        request.getRequestDispatcher("loginCandidate.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();
        String email= request.getParameter("email");
        String password= request.getParameter("password");

        Candidate candidate = new Candidate(email, password);
        candidate.updateStatusId(email);
        int statusId = candidate.signInUserCandidate();

        System.out.println(statusId+"-----------------Candidates------------------------------");
        String nextpage = "loginCandidate.jsp";

        switch (statusId) {
            case 1:
                if(candidate.getUserType().getUserTypeId() == 3){
                    System.out.println(candidate+"+++++++++++++user+++Candidate+++++++++++++++++++");
                    session.setAttribute("candidate", candidate);
                    // ArrayList<Edition>editionBook = Edition.collectAllEditions();
                    // session.setAttribute("editionBook", editionBook);
                   // nextpage="bookCandidateView.jsp";
                   nextpage="profile.do";
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

        response.sendRedirect(nextpage);
    }
    
}
