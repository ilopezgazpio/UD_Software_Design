package es.deusto.ingenieria.sd.singleton.printer;

public class EagerSingletonSpooler extends PrintSpooler 
{
	
	private static EagerSingletonSpooler instance = new EagerSingletonSpooler();

	private EagerSingletonSpooler() 
	{
		super.resetJobs();
		System.out.println("  # EAGER: Execute the constructor.");
	}

	public static EagerSingletonSpooler getInstance() 
	{
		System.out.println("  - EGAER: getting the unique instance ...");
		
		return instance;
	}

	public synchronized void resetPrintSpooler() 
	{
		System.out.println("  - EAGER: reset print spooler.");
		instance = new EagerSingletonSpooler();
		super.resetJobs();
	}
}