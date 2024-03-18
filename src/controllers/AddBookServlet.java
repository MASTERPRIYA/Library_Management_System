package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Book;
import models.Category;
import models.Edition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/addBooks.do")
public class AddBookServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException{
        request.getRequestDispatcher("addBooks.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException,ServletException{
        String nextPage = "addBooks.jsp";
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        String about = request.getParameter("about");
        String editions =request.getParameter("editions");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int price = Integer.parseInt(request.getParameter("price"));
        String ISBN = request.getParameter("ISBN");
        String date =request.getParameter("date");
        // try {
        //     Date dates = new SimpleDateFormat("dd-MM-yyyy").parse(date);  
        // } catch (ParseException e) {
        //     e.printStackTrace();
        // }
        // System.out.println(date);  
        Float weights = Float.parseFloat(request.getParameter("weights"));
        int pages = Integer.parseInt(request.getParameter("pages"));

        //Book book = new Book(name, author,new Category(categoryId), new Publisher(publisherId),about,edition,quantity,price,ISBN,date,weights,pages);
        Edition ed= new Edition(editions, quantity, price, ISBN, date, weights, pages, name, author, new Category(categoryId), about);
        if(ed.addBook()){
            System.out.println("0000000000000000000000000000000000000000000");
            ed.addBookEdition();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            ArrayList<Edition>editionBook = Edition.collectAllEditions();
            session.setAttribute("editionBook", editionBook);
            System.out.println("9999999999999999999999999999999999999");
            nextPage="bookLibrarianView.jsp";
        }
        else{
            nextPage="error.jsp";
        }

        request.getRequestDispatcher(nextPage).forward(request, response);
    }
}
