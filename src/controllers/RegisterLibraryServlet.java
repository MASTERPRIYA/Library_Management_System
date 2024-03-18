package controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.City;
import models.User;
import models.UserType;
import utils.AppUtility;
import utils.EmailSender;

@WebServlet("/registerLibrary.do")

public class RegisterLibraryServlet extends HttpServlet{
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
        request.getRequestDispatcher("registerLibrary.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException ,ServletException{
        HttpSession session = request.getSession();

    /*************************************RECAPTCHA****************************************************************/ 
       
        String responseToken = request.getParameter("g-recaptcha-response");
       // String secretKey = "6LfyQDopAAAAAJwyrtkTAhOtnq9gjriyV8yLJNHu";
        // String recaptchaURL ="https://www.google.com/recaptcha/api/siteverify";

        System.out.println(responseToken);

        ServletContext context = getServletContext();

        String recaptchaURL = context.getInitParameter("recaptcha_url");
        String secretKey = context.getInitParameter("secret_key");
        System.out.println(recaptchaURL);
        System.out.println(secretKey);
        boolean flag = AppUtility.checkRecaptchaResponse(recaptchaURL, secretKey, responseToken) ;
    /***************************************************************************************************************/ 
        
        String nextPage = "registerLibrary.jsp";

        if(flag){

            String name =request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            int cityId = Integer.parseInt(request.getParameter("city"));
            int userTypeId = Integer.parseInt(request.getParameter("userType"));
            String otp = AppUtility.generateOTP();

            User user = new User(name,email, password, phone,new City(cityId),new UserType(userTypeId),otp);


            if(user.signupuser()){
                EmailSender.sendAccVerificationLink(email, otp);
                nextPage = "signup_done.jsp";
            }
        }

      request.getRequestDispatcher(nextPage).forward(request, response);    

    }

    
}