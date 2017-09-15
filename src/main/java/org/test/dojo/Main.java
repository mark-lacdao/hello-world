package org.test.dojo;

import com.google.common.io.Files;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String REPORT_FILE = "\\\\tworks36\\xiam\\QA\\_Automation\\test.txt";

    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "mark.lacdao@teloworksinc.com";

        // Sender's email ID needs to be mentioned
        String from = "mark.lacdao@teloworksinc.com";

        // Assuming you are sending email from localhost
        String host = "mail.teloworksinc.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    private void writeToFile(String message, File destination) throws IOException {
        Files.write(message.getBytes(), destination);
    }

}
