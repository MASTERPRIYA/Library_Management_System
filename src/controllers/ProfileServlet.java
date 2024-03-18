package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.*;

@WebServlet("/profile.do")
public class ProfileServlet extends HttpServlet {
    public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();
        // Candidate candidates = new Candidate();
        
        // int candidateId = Integer.parseInt(request.getParameter("candidate_id"));
        // System.out.println(candidateId);
        // candidates.setCandidateId(candidateId);
        Candidate candidate = (Candidate)session.getAttribute("candidate");
        candidate.getCandidateDetails();
        // request.setAttribute("candidates", candidate);

       request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
    
}
