package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TVProgramManager extends UnicastRemoteObject implements ITVProgramManager 
{

	private static final long serialVersionUID = 1L;
	private String serverName;

	public TVProgramManager(String serverName) throws RemoteException 
	{
		super();
		this.serverName = serverName;
	}

	public void newTVProgram(String acro, String desc) 
	{
		System.out.println("  * Details for the new TV Program on the server ... '" + acro + "' and '" + desc + "'");
	}

	public void receiveMessage(String phone, String text) 
	{
		System.out.println("  * New message on the server ... '" + phone + "' and '" + text + "'");
	}
	
	public String getName() 
	{
		return serverName;
	}

	public String sayHello() throws RemoteException 
	{
		return "Connection established to server";
	}
}