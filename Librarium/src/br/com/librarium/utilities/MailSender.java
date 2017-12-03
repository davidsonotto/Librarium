/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.librarium.utilities;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Marcos Vinícius Brás de Oliveira
 */
public class MailSender {

    public static void sendMail(final String recipient, final String subject, final String message) throws AddressException, MessagingException {
        final String mailServer = "smtp.gmail.com";
        final String sender = "bookriddleproject@gmail.com";
        final String username = "bookriddleproject";
        final String password = "lukeeusouseupai";

        new Thread(new Runnable() {

            @Override
            public void run() {
                Properties props = System.getProperties();

                props.put("mail.smtp.host", mailServer);  // smtp.live.com  smtp.yahoo.com.br smtp.gmail.com
                props.put("mail.smtp.auth", "true");
                props.put("mail.debug", "true");
                props.put("mail.smtp.debug", "true");
                props.put("mail.mime.charset", "ISO-8859-1");
                props.put("mail.smtp.port", "465");    //25
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.fallback", "false");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

                try {
                    Session session = Session.getDefaultInstance(props);//recebe props   
                    InternetAddress iRecipient = new InternetAddress(recipient);
                    InternetAddress iSender = new InternetAddress(sender);
                    Message msg = new MimeMessage(session);

                    msg.setSentDate(new Date()); 
                    msg.setFrom(iSender);
                    msg.setRecipient(Message.RecipientType.TO, iRecipient);
                    msg.setSubject(subject);
                    msg.setContent(message, "text/HTML");

                    Transport transport = session.getTransport("smtp");
                    transport.connect(mailServer, username, password);
                    msg.saveChanges();
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
