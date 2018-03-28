package tr.bel.pendik.aquilamonitor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl impl = new org.springframework.mail.javamail.JavaMailSenderImpl();

        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.smtp.auth", "true");
        javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
        javaMailProperties.setProperty("mail.smtp.ssl.trust",
                "CASHUB.xxxx.bel.tr");
        impl.setJavaMailProperties(javaMailProperties);

        impl.setHost("CASHUB.xxxxxx.bel.tr");
        // impl.setPort(587);
        impl.setUsername("xxxx@xxxxxx.bel.tr");
        impl.setPassword("xxxxx");

        return impl;
    }

    @Bean
    public SimpleMailMessage templateMailMessage() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("xxxxxx@pendik.bel.tr");
        msg.setTo("xxxxx@pendik.bel.tr");
        msg.setSubject("Hata - >");
        msg.setText("<![CDATA[\nDear %s,\n	Mail Content : %s\n	]]>");
        return msg;
    }

}
