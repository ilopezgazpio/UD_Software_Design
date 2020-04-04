package es.deusto.ingenieria.sd.singleton.printer;

import java.util.ArrayList;
import java.util.List;

public enum EnumSingletonSpooler 
{
	INSTANCE;
	
	private List<String> printJobs = new ArrayList<>();

	private void insertJob(String job) 
	{
		this.printJobs.add(job);
	}

	private int countJobs() 
	{
		return this.printJobs.size();
	}

	public static void addJob(String job) 
	{
		INSTANCE.insertJob(job);
	}

	public static int jobNumber() 
	{
		return INSTANCE.countJobs();
	}
}