package es.deusto.ingenieria.sd.sms.client.controller;

import java.rmi.RemoteException;

import es.deusto.ingenieria.sd.sms.client.gui.SMSWindow;
import es.deusto.ingenieria.sd.sms.client.gui.SwitchServerGUI;
import es.deusto.ingenieria.sd.sms.client.remote.RMIServiceLocator;

public class SMSController {

	private RMIServiceLocator rsl;
	
	public SMSController(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args[0], args[1], args[2]);		
		new SMSWindow(this);
		new SwitchServerGUI(this);
	}
	
	public void switchServer(String ip, String port, String name){
		rsl.setService(ip, port, name);
		System.out.println("- Switching to server: " + ip + ":" + port + "/" + name);
	}
	
    public void newTVProgram(String acronym, String description){
    	try {
    		rsl.getService().newTVProgram(acronym, description);
    	} catch (Exception e){
    		System.err.println("$ Error sending new TV program: " + e.getMessage());
    	}
    }
    
    public void sendMessage(String phone, String text){
    	try{
    		rsl.getService().receiveMessage(phone, text);    		
    	} catch(Exception e){
    		System.out.println("$ Error sending a message: " + e.getMessage());
    	}
    }
  
    public void closeTVProgram(){
    
    }
    
    public void addMaximumNumberMessagesRestriction(){
    
    }
    
    public void addPermittedOptionsRestriction(){
        
    }

    public void addForbiddenWordsRestriction(){
    
    }

    public void generateReport(){
    
    }
    
    public void exit(){
    	System.exit(0);
    }
    
    public static void main(String[] args) throws RemoteException {    	
    	new SMSController(args);
    }
}