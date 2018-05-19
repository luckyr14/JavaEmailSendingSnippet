package org.com.email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSending {

	public static void main(String[] args) 
	{
		try
		{
			System.out.println(1);
			String host = "smtp.gmail.com";
			String user = "lakshmanraj169@gmail.com";
			String pass = "lrb@23792";
			String to   = "lakshman.raj@cloudjournee.com";
			String from = "lakshmanraj169@gmail.com";
			String sub  = "java testing";
			String text = "java email testing ";
			boolean sessionDebug = false;
			
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", "true");
			
//			java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Session mailSession = Session.getDefaultInstance(props, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress add = (new InternetAddress(to));
			msg.setRecipient(Message.RecipientType.TO, add);
			msg.setSubject(sub);
			msg.setSentDate(new Date());
			msg.setText(text);
			System.out.println(2);
			Transport t = mailSession.getTransport("smtp");
			t.connect(host,user,pass);
			t.sendMessage(msg, msg.getAllRecipients());
			System.out.println("mail send successfully");
			t.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
