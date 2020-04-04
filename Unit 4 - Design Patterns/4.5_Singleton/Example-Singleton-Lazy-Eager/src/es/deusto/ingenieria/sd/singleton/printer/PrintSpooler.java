package es.deusto.ingenieria.sd.singleton.printer;

import java.util.ArrayList;
import java.util.List;

public abstract class PrintSpooler 
{
	private List<String> printJobs = new ArrayList<String>();
	
	public void addJob(String job) 
	{
		this.printJobs.add(job);
		System.out.println("    - Job added: " + job);
	}

	public int countJobs() 
	{
		return this.printJobs.size();
	}
	
	protected void resetJobs() 
	{
		printJobs = new ArrayList<String>();
	}
	
	public abstract void resetPrintSpooler();
}