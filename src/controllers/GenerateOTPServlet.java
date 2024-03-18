package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.AppUtility;
import utils.SMSSender;

@WebServlet("/generate_otp.do")

public class GenerateOTPServlet  extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException , ServletException{
        HttpSession session = request.getSession();

        String phone = request.getParameter("phone");
        String otp = AppUtility.generateOTP();

        //send otp
        //SMSSender.sendOTP(phone, otp);

        //save in session
       //session.setAttribute("otp",otp);

        session.setAttribute("otp","88888888");
        System.out.println(otp+"--------------generate otp 88888888--------");

        //send boolean true
        response.getWriter().print(true);

    
    }
    
}
