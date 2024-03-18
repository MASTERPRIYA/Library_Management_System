package controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Librarian;
import models.User;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload_pic.do")
public class UploadPicServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        HttpSession session = request.getSession();

       User user = (User)session.getAttribute("user");
       //Librarian librarian = (Librarian)session.getAttribute("librarians");

       if(user!=null){
        
            if(ServletFileUpload.isMultipartContent(request)) {
                DiskFileItemFactory dif = new DiskFileItemFactory();
                ServletFileUpload sfu = new ServletFileUpload(dif);
                try{
                    FileItem fileItem = sfu.parseRequest(request).get(0);
                    String uploadLocation = getServletContext().getRealPath("WEB-INF/uploads/"+user.getEmail());
                    String fileName = fileItem.getName();
                    File file = new File(uploadLocation,fileName);

                    try{
                        fileItem.write(file);
                        user.savePic(fileName);
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }catch(FileUploadException e){
                    e.printStackTrace();
                }
            }

        }

    }
    
}
