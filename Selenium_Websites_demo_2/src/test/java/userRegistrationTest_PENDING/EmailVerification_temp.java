package userRegistrationTest_PENDING;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.SubjectTerm;

public class EmailVerification_temp {

	//https://www.tempmail.us.com
	public static void main(String[] args) {
		String host = "imap.gmail.com";  // Gmail's IMAP server
	//	String username = "your-email@gmail.com";  // Your Gmail address
	//	String password = "your-password";  // Your Gmail password or app password
		String username = "automationtestingpractice8443@gmail.com";  // Your Gmail address
		String password = "";  // Your Gmail password or app password


	        try {
	            Properties properties = new Properties();
	            properties.put("mail.store.protocol", "imaps");
	            properties.put("mail.imaps.host", host);
	            properties.put("mail.imaps.port", "993");
	            properties.put("mail.imaps.ssl.enable", "true");

	            // Create session
	            Session session = Session.getInstance(properties);
	            Store store = session.getStore("imaps");
	            store.connect(username, password);

	            // Open INBOX folder
	            Folder inbox = store.getFolder("INBOX");
	            inbox.open(Folder.READ_ONLY);

	            // Search for messages with a specific subject
	            Message[] messages = inbox.getMessages();  // Get all messages if no subject filter is needed.

	            // Process the messages
	            for (Message message : messages) {
	                System.out.println("Subject: " + message.getSubject());
	                
	                // Print message content (just for demonstration)
	                if (message.isMimeType("text/plain")) {
	                    System.out.println("Content: " + message.getContent().toString());
	                } else if (message.isMimeType("text/html")) {
	                    System.out.println("HTML Content: " + message.getContent().toString());
	                }
	            }

	            inbox.close(false);
	            store.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
    }

}
