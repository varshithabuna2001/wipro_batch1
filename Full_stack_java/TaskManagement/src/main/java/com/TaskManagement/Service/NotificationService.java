package com.TaskManagement.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.TaskManagement.DTO.EmailLogDTO;
import com.TaskManagement.Entity.EmailLog;
import com.TaskManagement.Repository.EmailLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {

    @Autowired
    private EmailLogRepository logRepo;

    @Autowired
    private JavaMailSender emailSender;


    public String sendEmail1(EmailLogDTO log) {

        boolean sentStatus = false;
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(log.getRecipientEmail());
            helper.setSubject(log.getSubject());
            helper.setText(log.getBody(), true);

            emailSender.send(message);
            sentStatus = true;

        } catch (MessagingException e) {
            sentStatus = false;
        }

        return sentStatus ? "Email sent successfully" : "Email sending failed";
    }


    
    public void sendEmail(EmailLogDTO dto) {

        final String fromEmail = "smrutipriya@gmail.com";
        final String password = "YOUR_GOOGLE_APP_PASSWORD";  // Must use App Password!

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {

            MimeMessage msg = new MimeMessage(session);   // <-- FIXED
            msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(dto.getRecipientEmail()));
            msg.setSubject(dto.getSubject());
            msg.setText(dto.getBody());

            Transport.send(msg);
            System.out.println("Email sent to: " + dto.getRecipientEmail());

        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
