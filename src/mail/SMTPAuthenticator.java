package mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class SMTPAuthenticator extends Authenticator{
    protected PasswordAuthentication getPasswordAuthentication() {
        String mail_id = "YourGmailAddress";
        String mail_pw = "암호키";

        return new PasswordAuthentication(mail_id,mail_pw);
    }
}
