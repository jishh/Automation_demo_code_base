package com.custommade.utility;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.custommade.configure.General;

/**
 * 
 * @author anokh ClassName: EmailUtility Description: This class is for sending
 *         the email
 */
public class EmailUtility {
	public static void main (String args[]) {
		EmailUtility emailobj = new EmailUtility();
		emailobj.sendEmail();
	}
	
	private String senderMailId;
	private String senderPassword;
	private String receipientMailId;
	private String projectHomeFolder;

	/*
	 * Method Name: sendEmail() Description: This function uses the jmail api to
	 * send the mail. sender mail id, password and receipient mail id are passed
	 * are read from config.properties file.
	 */
	public void sendEmail() {
		PropertyUtility propertyGettingObj = new PropertyUtility();
		senderMailId = propertyGettingObj.getProperty("Sendermailid");
		senderPassword = propertyGettingObj.getProperty("Senderpassword");
		receipientMailId = propertyGettingObj.getProperty("Receipientmailid");
		projectHomeFolder = propertyGettingObj.getProperty("Projecthomefolder");
		//String mailBody = mailText;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderMailId,
								senderPassword);
					}
				});
		try {
/*			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receipientMailId));
			message.setSubject("Testing Results");
			message.setText("Dear Tester, \n Please find the test results."
					+ "\n\n" + mailBody + "\n\n Thanks");
			Transport.send(message);*/
			
		    // Define message
		    MimeMessage message = 
		      new MimeMessage(session);
		    message.setFrom(
		      new InternetAddress("from-email@gmail.com"));
		    message.setRecipient(
		      Message.RecipientType.TO, 
		      new InternetAddress(receipientMailId));
		    message.setSubject("Testing result");
		    // create the message part 
		    MimeBodyPart messageBodyPart = 
		      new MimeBodyPart();
		    System.out.println(projectHomeFolder);
		   String fileAttachment = projectHomeFolder + "/test-output/emailable-report.html";
		   System.out.println(fileAttachment);
		    //String fileAttachment = "c://alignment.png";
		    //fill message
		    messageBodyPart.setText("Dear Tester, \n Please find the test results."
					+ "\n\n Thanks");
		    Multipart multipart = new MimeMultipart();
		    multipart.addBodyPart(messageBodyPart);
		    // Part two is attachment
		    messageBodyPart = new MimeBodyPart();
		    DataSource source = 
		      new FileDataSource(fileAttachment);
		    messageBodyPart.setDataHandler(
		      new DataHandler(source));
		    messageBodyPart.setFileName(fileAttachment);
		    multipart.addBodyPart(messageBodyPart);

		    // Put parts in message
		    message.setContent(multipart);

		    // Send the message
		    Transport.send( (Message)message );
		    System.out.println("done");
		  

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void sendEmailForPriority(String mailText) {
		senderMailId = PropertyUtility.getProperty("Sendermailid");
		senderPassword = PropertyUtility.getProperty("Senderpassword");
		receipientMailId = PropertyUtility.getProperty("Receipientmailid");
		projectHomeFolder = PropertyUtility.getProperty("Projecthomefolder");
		String mailBody = mailText;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderMailId,
								senderPassword);
					}
				});
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("from-email@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(receipientMailId));
				message.setSubject("Result (priority wise status) of tests run at " + General.testStartTime);
				message.setText("Dear Tester, \n Please find the test results."
						+ "\n\n" + mailBody + "\n\n Thanks");
				Transport.send(message);
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
