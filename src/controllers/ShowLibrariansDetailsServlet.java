package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Librarian;

import java.io.IOException;


@WebServlet("/showLibrariansDetails.do")
public class ShowLibrariansDetailsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();
        Librarian librarian = new Librarian();

        int librarianId = Integer.parseInt(request.getParameter("librarian_id"));
        librarian.setLibrarianId(librarianId);
        librarian.getDetails();
        request.setAttribute("librarian", librarian);
        request.getRequestDispatcher("showLibrariansDetails.jsp").forward(request, response);
    }
    
}
