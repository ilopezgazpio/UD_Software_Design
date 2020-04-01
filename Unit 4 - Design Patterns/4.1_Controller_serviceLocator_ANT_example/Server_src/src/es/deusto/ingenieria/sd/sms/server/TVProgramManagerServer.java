package es.deusto.ingenieria.sd.sms.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import es.deusto.ingenieria.sd.sms.server.remote.ITVProgramManager;
import es.deusto.ingenieria.sd.sms.server.remote.TVProgramManager;


public class TVProgramManagerServer {

	public static void main(String[] args) 
	{
		if (args.length != 3) 
		{
			System.exit(0);
		}

		if (System.getSecurityManager() == null) 
		{
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try 
		{
			ITVProgramManager TVServer = new TVProgramManager(args[2]);
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			registry.rebind(name, TVServer);		
			System.out.println("- TVProgramManager '" + name + "' active and waiting...");
		} 
		catch (Exception e) 
		{
			System.err.println("$ TVProgramManager exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}