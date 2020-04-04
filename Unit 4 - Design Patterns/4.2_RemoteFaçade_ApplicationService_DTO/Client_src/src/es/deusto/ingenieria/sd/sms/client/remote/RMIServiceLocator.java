package es.deusto.ingenieria.sd.sms.client.remote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramAdmin;
import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramReceiver;

public class RMIServiceLocator{
	// The Cache
	private ITVProgramAdmin adminService;
	private ITVProgramReceiver receiverService;

    public RMIServiceLocator()
    { 
     
    }

    public void setService(String ip, String port, String serviceName1, String serviceName2) 
    {    	
    	// Add your code to get the TARGET reference HERE    	
    }

    public ITVProgramAdmin getAdminService() 
    {
    	return adminService;
    }
    
    public ITVProgramReceiver getReceiverService() 
    {
    	return receiverService;
    }
}
