package com.happytail.reservation.model.util;

import java.sql.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


public class MailUtil implements Runnable{
	private String email;	//收件人電子信箱
	private String username;
	private Date createDate;
	private Integer availableDateTime;
	private String petName;
	
	
	
	public MailUtil(String email, String username, Date createDate,
			Integer availableDateTime, String petName) {
		this.email = email;
		this.username = username;
		this.createDate = createDate;
		this.availableDateTime = availableDateTime;
		this.petName = petName;
		
	}	
	
	public void run() {
			
			String host = "smtp.gmail.com";	//host name of SMTP servers
			String from = "petProject113@gmail.com";
		
			Properties props = System.getProperties();
		
			props.setProperty("mail.smtp.host", host);
			props.setProperty("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
		
			Authenticator auth =  new Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("petProject113@gmail.com", "eeit11339");
				}
			};
		
			Session session = Session.getInstance(props, auth);
			
			
			Message msg = new MimeMessage(session);
			try {
				msg.setFrom(new InternetAddress(from));	//設置寄信人電子信箱
				msg.setRecipient(RecipientType.TO, new InternetAddress(email));	//設置收信人電子信箱
				
				msg.setSubject("HappyTail預約成功!");
				
				
				
				StringBuilder content = new StringBuilder();
				content.append("<html><head></head><body><h1>預約成功 </h1>");
				content.append("<h1>會員:" + username +"你好</h1>");
				content.append("<h1>您的寵物:" + petName +"</h1>");
				content.append("<h1>預約的時間為: " + createDate +"  "+ availableDateTime +":00</h1>");
				content.append("</body></html>");				
				
				msg.setContent(content.toString(), "text/html;charset=UTF-8");
				
				Transport.send(msg);
				System.out.println("郵件已發送");
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		
	}
}


