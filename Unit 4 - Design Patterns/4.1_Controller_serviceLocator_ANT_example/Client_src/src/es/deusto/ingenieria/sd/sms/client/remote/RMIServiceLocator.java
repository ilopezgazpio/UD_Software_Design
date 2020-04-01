package es.deusto.ingenieria.sd.sms.client.remote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramManager;

public class RMIServiceLocator
{
	/** 
	 * The Cache - Limitation: one server at a time
	 * Proposed improvement: list of services
	 */
	
	private ITVProgramManager service = null;

    /** Creates a new instance of RMIServiceLocator */
    public RMIServiceLocator() { }

    public void setService(String ip, String port, String serviceName) 
    {    
    	

		// Add your code to locate and initialize the SERVICE reference



    }
    
    public ITVProgramManager getService() 
    {    	
    	// Add your code to return reference to ServiceLocator
    }
}
