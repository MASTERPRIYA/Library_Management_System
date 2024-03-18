package utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSSender {
    static final String ACCOUNT_SID = "ACb36d12ee71d1176d8c19f376086bebae";
    static final String AUTH_TOKEN = "6edda617ec8c9405f5003ef06bfcd518";

    public static void sendOTP(String phone, String otp) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
            new com.twilio.type.PhoneNumber("+91"+phone),
                new com.twilio.type.PhoneNumber("+12059527769"),
                "Welcome to Book Mining Library ! OTP:"+otp)
            .create();

        System.out.println(message.getBody());
    }
}