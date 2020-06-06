package com.happytail.member.util;

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
	private String code;	//用戶激活碼
	
	
	public MailUtil(String email, String code) {
		this.email = email;
		this.code = code;
		
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
				
				msg.setSubject("啟用快樂尾巴會員帳號");
				
				StringBuilder content = new StringBuilder();
				content.append("<html><head></head><body><h2>請點擊下面鏈結以啟用您的HappyTail會員帳號 : </h2>");
				content.append("<h3><a href='http://localhost:8080/happytail/accountStart?code=");
				content.append(code);
				content.append("'>");				
				content.append("http://localhost:8080/happytail/code=");
				content.append(code);
				content.append("</a>");
				content.append("</h3></body></html>");				
				
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


