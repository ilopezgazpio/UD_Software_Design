package es.deusto.ingenieria.sd.sms.server.gateway;

public class TranslationToScreen implements IGateway
{
	private String IP;
	private String PORT;
	private String fromLang;
	private String toLang;

	public TranslationToScreen(String IP, String PORT, String fromLang, String toLang)
	{
		this.IP = IP;
		this.PORT = PORT;
		this.fromLang = fromLang;
		this.toLang = toLang;
	}
	
	@Override
	public String sendMessage(String message) 
	{
		// build string
		
		// create socket and connect with server
		
		//process result
		
		// return
		
		return null;
	}

}
