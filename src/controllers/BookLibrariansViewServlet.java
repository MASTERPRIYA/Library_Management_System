package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Edition;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/bookLibrarianView.do")
public class BookLibrariansViewServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        // Edition edition = new Edition();
        // edition.getBookDetails();
         ArrayList<Edition>editionBook = Edition.collectAllEditions();
        request.setAttribute("editionBook", editionBook);
        request.getRequestDispatcher("bookLibrarianView.jsp").forward(request, response);
    }
    
}
