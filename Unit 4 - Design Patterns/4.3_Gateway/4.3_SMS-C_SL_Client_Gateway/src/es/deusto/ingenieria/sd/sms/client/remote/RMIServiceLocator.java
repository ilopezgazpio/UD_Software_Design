package es.deusto.ingenieria.sd.sms.client.remote;

import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramManager;

public class RMIServiceLocator 
{
	private ITVProgramManager service = null;

    /** Creates a new instance of RMIServiceLocator */
    public RMIServiceLocator() 
    {
    	
    }

    public void setService(String ip, String port, String serviceName) 
    {
    	
    }
    
    public ITVProgramManager getService() 
    {    	
    	return service;
    }
}