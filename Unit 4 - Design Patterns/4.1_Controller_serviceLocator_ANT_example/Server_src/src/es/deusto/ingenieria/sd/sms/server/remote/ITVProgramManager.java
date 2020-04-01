package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITVProgramManager extends Remote 
{
	public void newTVProgram(String acronym, String description) throws RemoteException;
    public void receiveMessage(String phone, String text) throws RemoteException;
	String sayHello() throws RemoteException;
}