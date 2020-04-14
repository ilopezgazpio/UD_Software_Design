package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import es.deusto.ingenieria.sd.sms.server.gateway.TranslationToScreen;


public class TVProgramManager extends UnicastRemoteObject implements ITVProgramManager 
{

	private static final long serialVersionUID = 1L;
	private String serverName;

	private TranslationToScreen	gateway;

	public TVProgramManager(String[] args) throws RemoteException 
	{
		super();
		this.serverName = args[2];
		//Initialize the Gateway using 4 parameters: IP and port of the translation service, source and target languages.
		this.gateway = new TranslationToScreen(args[3], args[4], args[5], args[6]);
	}

	public void newTVProgram(String acro, String desc) 
	{
		System.out.println("  * Details for the new TV Program on the server ... '" + acro + "' and '" + desc + "'");
	}

	public void receiveMessage(String phone, String text) 
	{
		System.out.println("  * New message on the server ... '" + phone + "' and '" + text + "'");
		
		//Invoke the Gateway to translate the text ant print the translation in the console.
		System.out.println(this.gateway.sendMessage(text));
	}
	
	public String getName() 
	{
		return serverName;
	}
}