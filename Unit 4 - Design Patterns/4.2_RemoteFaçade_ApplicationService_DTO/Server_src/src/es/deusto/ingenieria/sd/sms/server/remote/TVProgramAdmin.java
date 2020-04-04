package es.deusto.ingenieria.sd.sms.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import es.deusto.ingenieria.sd.sms.server.TVProgramService;
import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramAssembler;
import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramDTO;

//This class implements Façade and AppService Patterns
public class TVProgramAdmin extends UnicastRemoteObject implements ITVProgramAdmin 
{

	private static final long serialVersionUID = 1L;
	private TVProgramService progServ;

	public TVProgramAdmin(TVProgramService progServ) throws RemoteException 
	{
		super();
		this.progServ = progServ;
	}

	@Override
	public void newTVProgram(String acronym, String description) throws RemoteException 
	{
		// ADD YOUR CODE HERE - CREATING A NEW TV PROGRAM
	}

	@Override
	public void closeTVProgram(String acronym) throws RemoteException 
	{		
		// ADD YOUR CODE HERE - DELETING A TV PROGRAM

	}

	public List<TVProgramDTO> getTVPrograms() throws RemoteException 
	{
	
		// ADD YOUR CODE HERE - GETTING A LIST OF TV PROGRAMS AND ASSEMBLING THEM FOR TRANSMISSION
	}
}
