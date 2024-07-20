import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender implements MailService {

    public void sendMail(String to, String subject, String content) {
        Session session = createEmailSession();
        try {
            Message message = createEmailMessage(session, to, subject, content);
            Transport.send(message);
            System.out.println("Email sent!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public Session createEmailSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kaay2958@gmail.com", "ybza hsvt bemy hcix");
            }
        });
    }

    public Message createEmailMessage(Session session, String to, String subject, String content) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(content);
        return message;
    }
}

   
