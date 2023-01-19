package receivejava;

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class receivejava {
public static void check(String host, String storeType, String user, String password)
	{
		try{
			Properties prop = new Properties();
			prop.put("mail.pop3.host",host);
			prop.put("mail.pop3.port","995");
			prop.put("mail.pop3.starttls.enable","true");
			Session emailSession = Session.getDefaultInstance(prop);
			
			Store store = emailSession.getStore("pop3s");
			store.connect(host, user, password);
			
			Folder emailFolder = store.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			
			Message messages[] = emailFolder.getMessages();
			
			int i =((messages.length)-1);
			
				Message message = messages[i];
				
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject : " + message.getSubject());
				System.out.println("From : " + message.getFrom()[0]);
				
				emailFolder.close(true);
				store.close();
		} catch (NoSuchProviderException e){
		} catch (MessagingException e){
		} catch (Exception e){
		}
	}

	public static void main(String[] args)
	{
		String host ="pop.gmail.com";
		String mailStoreType ="pop";
		String username ="";
		String password ="";
		
		check(host, mailStoreType, username, password);
	}
}

