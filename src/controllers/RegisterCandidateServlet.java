package controllers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Candidate;
import models.City;
import models.Edition;
import models.UserType;
import utils.AppUtility;
import utils.EmailSender;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/registerCandidate.do")
public class RegisterCandidateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
        request.getRequestDispatcher("registerCandidate.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
        HttpSession session = request.getSession();

//+++++++++++++++++ReCaptcha++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        String responsetoken = request.getParameter("g-recaptcha-response");
        System.out.println(responsetoken);
        ServletContext context = getServletContext();
        String recaptchaURL = context.getInitParameter("recaptcha_url");
        String secretKey = context.getInitParameter("secret_key");
        boolean flag= AppUtility.checkRecaptchaResponse(recaptchaURL, secretKey, responsetoken);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 

        String nextPage="registerCandidate.jsp";
        if(flag){
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int cityId = Integer.parseInt(request.getParameter("city"));
            int userTypeId = Integer.parseInt(request.getParameter("userType"));
            String gender = request.getParameter("gender");
            String organization = request.getParameter("organization");
            String adhaarcard = request.getParameter("adhaarcard");
            String dob = request.getParameter("dob");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String otp = AppUtility.generateOTP();

         Candidate candidate = new Candidate(name, email, password, new City(cityId), new UserType(userTypeId), gender, organization, adhaarcard, dob, phone, address, otp);

            if(candidate.getUserType().getUserTypeId()==3){
                if(candidate.signUpUserCandidate()){
                    candidate.signUpCandidate();
                    System.out.println("================================");
                    if(candidate.getUserType().getUserTypeId()==3){
                        System.out.println("|||||||||||||||||||||||||||Candidate Login|||||||||||||||||||||");
                        EmailSender.sendConfirmationMail(email, password);
                        System.out.println(userTypeId+"-------------------UserTypeId candidate");
                        session.setAttribute("candidate", candidate);
                        nextPage="loginCandidate.jsp";

                    }
                }
            }else{
                nextPage="error.jsp";
            }
        }

            request.getRequestDispatcher(nextPage).forward(request, response);
        
}
    
}
