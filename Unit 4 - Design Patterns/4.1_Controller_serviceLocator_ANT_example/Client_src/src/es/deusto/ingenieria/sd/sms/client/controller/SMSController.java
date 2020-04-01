package es.deusto.ingenieria.sd.sms.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.sms.client.gui.SMSWindow;
import es.deusto.ingenieria.sd.sms.client.gui.SwitchServerGUI;
import es.deusto.ingenieria.sd.sms.client.remote.RMIServiceLocator;

public class SMSController 
{
	
	private RMIServiceLocator rsl = null;
	
	public SMSController(String[] args) throws RemoteException 
	{		
		// Add your related code for the initialization of the Service Locator
		
                    // Add your code for the initializationf of the windows
	}
	
    public void newTVProgram(String acronym, String description)
    {    	
    	try 
    	{
    		// Add your code related to getting the service and requesting creation of TVProgram    		
    	
    	} 
    	catch (Exception e)
    	{
    		System.err.println("$ Error sending new TV program: " + e.toString());
    	}
    }
    
    public void sendMessage(String phone, String text){
    	try
    	{	
    		// Add your related to getting the service and sending a message   		
    		
    	} 
    	catch(Exception e)
    	{
    		System.out.println("$ Error sending a message: " + e.getMessage());
    	}
    }
    
	public void switchServer(String ip, String port, String name)
	{
		
		// Add your code related to switching servers		

	}
  
    public void closeTVProgram() {
    	//This method will be use in other Labs.
    }
    
    public void addMaximumNumberMessagesRestriction() {
    	//This method will be use in other Labs.
    }
    
    public void addPermittedOptionsRestriction() {
    	//This method will be use in other Labs.
    }

    public void addForbiddenWordsRestriction() {
    	//This method will be use in other Labs.
    }

    public void generateReport() {
    	//This method will be use in other Labs.
    }
    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new SMSController(args);
    }
}
