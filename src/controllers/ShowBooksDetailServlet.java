package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Edition;

import java.io.IOException;

@WebServlet("/showBooksDetails.do")
public class ShowBooksDetailServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();  
        Edition edition = new Edition();
        int editionId = Integer.parseInt(request.getParameter("edition_id"));
        System.out.println(editionId);
        edition.setEditionId(editionId);
        System.out.println(editionId);
        edition.getBookDetails();
        request.setAttribute("edition",edition);
        request.getRequestDispatcher("showBooksDetails.jsp").forward(request, response);
    }
    
}
