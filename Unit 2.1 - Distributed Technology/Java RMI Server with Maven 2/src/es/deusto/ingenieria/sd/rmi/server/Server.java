package es.deusto.ingenieria.sd.rmi.server;

import com.sun.org.apache.xerces.internal.impl.PropertyManager;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;
import java.util.HashMap;
import java.util.Properties;

public class Server extends UnicastRemoteObject implements IServer {

	private static final long serialVersionUID = 1L;
	private int cont = 0;
	private HashMap <String, String> registeredUsers = null;

	protected Server() throws RemoteException 
	{
		super();
		registeredUsers = new HashMap<String, String> ();
	}

	@Override
	public String sayHello() 
	{
		cont++;
		System.out.println(" * Client number: " + cont);
		return "Hello World!";
	}
	
	@Override
	public String sayMessage(String login, String password, String message) throws RemoteException, InvalidUser
	{
		if (registeredUsers.containsValue(login)) {

			if (registeredUsers.get(login).contentEquals(password)) {
				return message;
			} else {
				throw new InvalidUser("Incorrect password for user " + login);
			}

		} else {
			throw new InvalidUser("User name " + login + "is not present among the registered users");
		}
	}

	@Override
	public void registerUser(String login, String password) throws RemoteException, InvalidUser 
	{
		if ( registeredUsers.containsValue(login) == false ) {
			registeredUsers.put(login, password);			
		} else {
			throw new InvalidUser("User name " + login + " is already in the database");
		}		
	}
	

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
			System.exit(0);
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		System.setProperty("java.rmi.server.CodeBase", name);
		System.setProperty("java.security.policy", "resources/java.policy");


		try 
		{	
			IServer objServer = new Server();
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			//Naming.rebind(name, objServer);
			registry.rebind(name, objServer);
			System.out.println("* Server '" + name + "' active and waiting...");			
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}

		Thread.sleep(Integer.MAX_VALUE);
	}
	
}