package com.pfe.email;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailStoreController {
   @RequestMapping(value = "/sendemail")
   public void sendEmail() {
      
      
      final String username = "nexsoft.tn@gmail.com";
      final String password = "user5_mourad";

      Properties prop = new Properties();
      
	  prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.port", "465");
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.smtp.socketFactory.port", "465");
      prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      
      Session session = Session.getInstance(prop,
              new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(username, password);
                  }
              });

      try {

          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress("tunisie.telecom.recharge@gmail.com"));
          message.setRecipients(
                  Message.RecipientType.TO,
                  InternetAddress.parse("tunisie.telecom.recharge@gmail.com")
          );
          message.setSubject("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
          message.setText("Bonjour,"
                  + "\n\n otre Msg est bien Envoyer!");

          Transport.send(message);

          System.out.println("Done");

      } catch (MessagingException e) {
          e.printStackTrace();
      }
      //return message;
  }
      
      
      
      
      
      
   }   