package es.deusto.ingenieria.sd.sms.client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.sms.client.gui.SMSWindow;
import es.deusto.ingenieria.sd.sms.client.remote.RMIServiceLocator;
import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramDTO;

public class SMSController 
{

	private RMIServiceLocator rsl;

	public SMSController(String[] args) throws RemoteException 
	{
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2], args[3]);
		new SMSWindow(this);
	}

	public List<TVProgramDTO> getTVPrograms() 
	{	
		// ADD YOUR CODE HERE
	}

	public void newTVProgram(String acronym, String description) 
	{		
		// ADD YOUR CODE HERE
	}

	public void sendMessage(String phone, String text) 
	{
		// ADD YOUR CODE HERE
	}

	public void closeTVProgram(String acro) 
	{
		// ADD YOUR CODE HERE
	}

	public void addMaximumNumberMessagesRestriction() 
	{
		
	}

	public void addPermittedOptionsRestriction() 
	{
		
	}

	public void addForbiddenWordsRestriction() 
	{
		
	}

	public void generateReport() 
	{
		
	}

	public void exit() 
	{
		System.exit(0);
	}

	public static void main(String[] args) throws RemoteException 
	{
		new SMSController(args);
	}
}
