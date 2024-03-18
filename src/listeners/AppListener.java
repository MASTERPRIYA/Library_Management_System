package listeners;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import models.Book;
import models.Category;
import models.City;
import models.Edition;
import models.Gender;
import models.Organization;
import models.Status;
import models.UserType;
import utils.AppUtility;

public class AppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event){
        ServletContext context = event.getServletContext();
        
        System.out.println("++++++++++++++++++++BOOK MINING LIBRARY++++++++++++++++++++++");
        System.out.println("------------------------------------------------------------");
        System.out.println("----------------------Start--------------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("----------------------Loading------------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("-----------------------City-----------------------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        ArrayList<City> cities = City.collectAllCities();
        context.setAttribute("cities",cities);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("----------------------UserType---------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        ArrayList<UserType> userTypes = UserType.collectAllUserTypes();
        context.setAttribute("userTypes", userTypes);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("----------------------Status---------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        ArrayList<Status> status = Status.collectAllStatus();
        context.setAttribute("status", status);

        AppUtility.servletContext =  context;
        AppUtility.fromEmail= context.getInitParameter("from_email");
        AppUtility.fromEmailPassword = context.getInitParameter("from_email_password");


        ArrayList<Category> categories = Category.collectAllCategories();
        context.setAttribute("categories", categories);

        ArrayList<Edition> editionBook = Edition.collectAllEditions();
        context.setAttribute("editionBook", editionBook);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("-------------------------Finally Started---------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------");
    }

    public void contextDestroyed(ServletContextEvent event){

    }


    
}

