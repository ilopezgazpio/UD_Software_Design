package es.deusto.ingenieria.sd.sms.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import es.deusto.ingenieria.sd.sms.server.data.Message;
import es.deusto.ingenieria.sd.sms.server.data.TVProgram;

// THIS IS THE APPLICATION SERVICE CLASS
public class TVProgramService 
{

	private Map<String, TVProgram> programs = new TreeMap<String, TVProgram>();

	public TVProgramService() 
	{
		programs.put("BBR", new TVProgram("BBR", "BIG BROTHER"));
		programs.put("CGO", new TVProgram("CGO", "CELEBRITY GOSSIP"));
	}

	public synchronized void createTVProgram(String acronym, String description) 
	{
		/*
		 * ADD YOUR CODE HERE Create a new TV program and put it in the Map.
		 * Check that the TV program does not already exist
		 */	
	}

	public synchronized void deleteTVProgram(String acronym) 
	{
		// ADD YOUR CODE HERE - DELETING TV PROGRAMS
	}

	public synchronized List<TVProgram> getTVPrograms() 
	{

		// ADD YOUR CODE HERE - RETRIEVING TV PROGRAMS FROM MA
	}

	public synchronized void receiveMessage(String phone, String text) 
	{
		/*
		 * ADD YOUR CODE HERE If the TV program does not exist, the message is
		 * ignored If the TV program exists, the message is created
		 */
	}

	protected synchronized TVProgram findTVProgram(String acro) 
	{
		return programs.get(acro);
	}
}
