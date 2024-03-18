package utils;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.Message;

public class EmailSender{
    static Properties props = new Properties();

    static {
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
    }

    public static void sendEmail(String toEmail, String subject , String message){
        Session session = Session.getInstance(props, new EmailAuthenticator());

        MimeMessage mm = new MimeMessage(session);

        try {
            mm.setFrom(AppUtility.fromEmail);
            mm.setRecipients(Message.RecipientType.TO, toEmail);
            mm.setSubject(subject);
            mm.setContent(message,"text/html");

            Transport.send(mm);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void sendAccVerificationLink(String email , String vfcode){
        String VerificationEmail="<h1>Click over the link for verification </h1>"+
        "<br><br><a href='http://localhost:8080/l_m_s/evfc.do?email="+email+"&vfcode="+vfcode+"'>Verification Link</a>";
        System.out.println(VerificationEmail);
        sendEmail(email,"Verification Link",VerificationEmail);
    }

    public static void sendCongratulationMail(String email,String password){
        String CongratulationMail="<h1>Congratulation</h1>"+
        "Your account is created now you are the part of Book Mining Library."+
        "Your email and password are"+ " "+email+" "+password;
        System.out.println(CongratulationMail);
        sendEmail(email,"CongratulationMail",CongratulationMail);
    }

    public static void sendConfirmationMail(String email,String password){
        String ConfirmationMail="<h1>Yayyy! </h1> Your account is created . With email"+" : "+email;
       
        System.out.println(ConfirmationMail);
        sendEmail(email, "ConfirmationMail", ConfirmationMail);

    }
    
}

class EmailAuthenticator extends Authenticator{

    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(AppUtility.fromEmail, AppUtility.fromEmailPassword);
    }

}