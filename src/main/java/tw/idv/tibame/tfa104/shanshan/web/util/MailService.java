package tw.idv.tibame.tfa104.shanshan.web.util;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import redis.clients.jedis.Jedis;

public class MailService {

	// 設定傳送郵件:至收信人的Email信箱,Email主旨,Email內容
	public boolean sendMail(String to, String subject, String type, Integer memberId) {

		try {
			// 設定使用SSL連線至 Gmail smtp Server
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			// ●設定 gmail 的帳號 & 密碼 (將藉由你的Gmail來傳送Email)
			// ●須將myGmail的【安全性較低的應用程式存取權】打開
			final String myGmail = "shanshantester@gmail.com";
			final String myGmail_password = "TFA104shanshan";
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(myGmail, myGmail_password);
				}
			});
			
			String token = UUID.randomUUID().toString().replace("-", "");

			StringBuilder messageText = new StringBuilder();
			messageText.append("<a href='http://localhost:8080/shanshan/"); // need to change localhost once we use GCP
			messageText.append(type);
			messageText.append("?token=");
			messageText.append(token);
			messageText.append("'>");
			messageText.append(" <FONT face='MS UI Gothic' size='3'> <b>");
			messageText.append(subject);
			messageText.append("</b></FONT></a>");

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myGmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// 設定信中的主旨
			message.setSubject(subject);
			// 設定信中的內容--> sending a link for them to click
			message.setContent(messageText.toString(), "text/html; charset=UTF-8");

			Transport.send(message);
			Jedis jedis = new Jedis("localhost", 6379);
			jedis.set(token, memberId.toString());
//			System.out.println(token);
			jedis.expire(token, 120); // setting timeout time (jedis will delete this token)
			System.out.println("傳送成功!");
			jedis.close();
			return true;
		} catch (MessagingException e) {
			System.out.println("傳送失敗!");
			e.printStackTrace();
			return false;
		}
	}

}
