package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/check_otp.do")
public class CheckOTPServlet extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
        HttpSession session = request.getSession();

        String otp = request.getParameter("otp");
        System.out.println(otp+"-------------otp--------------------------------");

        String sessionOTP = (String)session.getAttribute("otp");
        System.out.println(sessionOTP+"-----------session otp----------------------");

        boolean flag = false;

        if(otp.equals(sessionOTP)){
            flag = true;
        }

        response.getWriter().print(flag);

    }
    
}
