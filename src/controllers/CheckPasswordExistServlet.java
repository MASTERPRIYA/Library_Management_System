// package controllers;

// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import java.io.IOException;
// import models.User;

// @WebServlet("/check_password_exist.do")
// public class CheckPasswordExistServlet extends HttpServlet {
//     public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException{
//         String email = request.getParameter("email");
//         String password = request.getParameter("password");
//         boolean flag = false;

//         if (User.CheckPasswordExist(email,password)){
//             System.out.println(email);
//             System.out.println(password);
//             flag = true;
//             System.out.println(email);
//             System.out.println(password);

//         }

//         response.getWriter().print(flag);
//     }
    
// }
