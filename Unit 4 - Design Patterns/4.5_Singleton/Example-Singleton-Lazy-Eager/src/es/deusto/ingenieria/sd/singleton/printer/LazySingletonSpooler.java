package es.deusto.ingenieria.sd.singleton.printer;

public class LazySingletonSpooler extends PrintSpooler 
{
	private static LazySingletonSpooler instance = null;

	private LazySingletonSpooler() 
	{
		super.resetJobs();
		System.out.println("  # LAZY: Execute the constructor.");
	}

	public static LazySingletonSpooler getInstance() 
	{
		System.out.println("  - LAZY: getting the unique instance ...");
		
		if (instance == null) 
		{
			instance = new LazySingletonSpooler();
		}
		
		return instance;
	}

	public synchronized void resetPrintSpooler() 
	{
		System.out.println("  - LAZY: reset print spooler.");
		instance = new LazySingletonSpooler();
	}
}