package utils;

import java.io.InputStream;
import java.util.Random;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletContext;

import java.io.IOException;


public class AppUtility {

    public static ServletContext servletContext;
    public static String fromEmail;
    public static String fromEmailPassword;

    public static String generateOTP(){
        return Integer.toString(new Random().nextInt(888888)+111111);
    }
    public static boolean checkRecaptchaResponse(String recaptchaURL,String secretKey,String responseToken) throws IOException{
       // String url = recaptchaURL+"?secretKey="+secretKey+"&responseToken"+reponseToken;
        String url = recaptchaURL+"?secret="+secretKey+"&response="+responseToken;
        InputStream is = ThirdPartyServer.sendThirdPartyRequest(url);
        
        // JsonReader jr = Json.createReader(is);
        // JsonObject jo = jr.readObject();
        // boolean result = jo.getBoolean("success");

        return Json.createReader(is).readObject().getBoolean("success");
    }
}
