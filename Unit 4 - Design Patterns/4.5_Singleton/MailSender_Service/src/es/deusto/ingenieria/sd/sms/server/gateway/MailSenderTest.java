package es.deusto.ingenieria.sd.sms.server.gateway;

public class MailSenderTest {

	public static void main(String[] args) 
	{
		try 
		{
			MailSender mailSender = new MailSender(args[0]);
			System.out.println(" - Sending an email...");
			mailSender.sendMessage("Hello World :)");
			System.out.println(" - Email sent!");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}