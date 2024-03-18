package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.City;
import models.Librarian;
import models.User;
import models.UserType;
import utils.EmailSender;

@WebServlet("/addLibrarian.do")
public class AddLibrarianServlet extends HttpServlet{
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
        request.getRequestDispatcher("addLibrarian.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
      
        HttpSession session = request.getSession();
        User user =(User)session.getAttribute("user");
       
        String nextPage="addLibrarian.jsp";
        System.out.println("111111111111111111111111111111111111111");
      
        String name = request.getParameter("name");
        int userTypeId = Integer.parseInt(request.getParameter("userType"));
        String email = request.getParameter("email");
        int cityId = Integer.parseInt(request.getParameter("city"));
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String adhaarcard = request.getParameter("adhaarcard");
        String qualification = request.getParameter("qualification");
        int experience = Integer.parseInt(request.getParameter("experience"));
        String about = request.getParameter("about");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");

        Librarian librarian = new Librarian(name,new UserType(userTypeId),email,new City(cityId), password,phone,adhaarcard, qualification, experience, about);
        System.out.println("==============================================");

        if(librarian.getUserType().getUserTypeId()==2){
            if(librarian.signUpUserLibrarian()){
                librarian.signUpLibrarian();
                System.out.println("...................................");
                if(librarian.getUserType().getUserTypeId()==2){
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||");
                    EmailSender.sendCongratulationMail(email,password);
                    System.out.println("/////////////////////////////////////////////////////");
                    ArrayList<Librarian> librarians = Librarian.collectAllLibrarians(userTypeId);
                    System.out.println(userTypeId);
                    System.out.println(librarian);
                    session.setAttribute("librarians", librarians);
                    nextPage="tableLibrary.jsp";
                }
            }
        }else{
            nextPage="error.jsp";
        }

        request.getRequestDispatcher(nextPage).forward(request, response);

    }   
}