package userRegistrationTest_PENDING;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.SubjectTerm;

public class EmailVerification {

	public static void main(String[] args) {
		String host = "imap.gmail.com"; // or "pop.gmail.com" for POP3
       // String username = "your-email@gmail.com";
      //  String password = "your-email-password";
        String username = "automationtestingpractice8443@gmail.com";  // Your Gmail address
		String password = ""; 
        try {
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.imaps.host", host);
            properties.put("mail.imaps.port", "993");
            properties.put("mail.imaps.ssl.enable", "true");

            Session session = Session.getInstance(properties);
            Store store = session.getStore("imaps");
            store.connect(username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Search for the registration email
            Message[] messages = inbox.search(new SubjectTerm("Welcome to Example!"));

            if (messages.length > 0) {
                Message email = messages[0];
                System.out.println("Email found: " + email.getSubject());

                // Extract email content
                String emailContent = getEmailContent(email);
                System.out.println("Email Body: " + emailContent);

                // If there's a confirmation link, extract and use it
                String confirmationLink = extractConfirmationLink(emailContent);
                System.out.println("Confirmation Link: " + confirmationLink);
            } else {
                System.out.println("No registration email found.");
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Function to extract email content
    private static String getEmailContent(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            return mimeMultipart.getBodyPart(0).getContent().toString();
        }
        return "";
    }

    // Function to extract the confirmation link from email body
    private static String extractConfirmationLink(String emailContent) {
        String keyword = "http";
        int startIndex = emailContent.indexOf(keyword);
        if (startIndex != -1) {
            int endIndex = emailContent.indexOf(" ", startIndex);
            return (endIndex == -1) ? emailContent.substring(startIndex) : emailContent.substring(startIndex, endIndex);
        }
        return "No link found";
    }

}
