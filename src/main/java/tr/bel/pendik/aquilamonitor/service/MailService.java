package tr.bel.pendik.aquilamonitor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SimpleMailMessage alertMailMessage;

    public void sendMail(String from, String to, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        //mailSender.send(message);

    }

    public void sendAlertMail(String to, String subject, String body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        //mailSender.send(message);

    }

    public void sendAlertMail(String alert, String to) {

        SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
        mailMessage.setSubject("System Monitor Application");
        mailMessage.setText(alert);
        mailMessage.setTo(to);
        //	mailSender.send(mailMessage);

    }

    public void sendAlertMail(String alert, String[] to) {
        for (int i = 0; i < to.length; i++) {
            String eposta = to[i];

            SimpleMailMessage mailMessage = new SimpleMailMessage(
                    alertMailMessage);
            mailMessage.setSubject("System Monitor Application");
            mailMessage.setText(alert);
            mailMessage.setTo(eposta);
            try {
                //		mailSender.send(mailMessage);
                System.err.println("To this user " + eposta + " mail send!");
            } catch (MailSendException e) {
                System.err.println("To this user " + eposta
                        + " mail send problem-> " + e.getMessage());
            }
        }
    }

    public void sendAlertMail(String alert) {

        SimpleMailMessage mailMessage = new SimpleMailMessage(alertMailMessage);
        mailMessage.setSubject("System Monitor Application");
        mailMessage.setText(alert);
//		mailSender.send(mailMessage);

    }

}