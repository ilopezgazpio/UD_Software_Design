package es.deusto.ingenieria.sd.singleton.printer.test;

import es.deusto.ingenieria.sd.singleton.printer.EagerSingletonSpooler;
import es.deusto.ingenieria.sd.singleton.printer.LazySingletonSpooler;
import es.deusto.ingenieria.sd.singleton.printer.EnumSingletonSpooler;

public class PrintSpoolerTest 
{

	public static void main(String[] args) 
	{
		System.out.println("Testing LAZY Spooler ...");
		LazySingletonSpooler lazyPrinter = LazySingletonSpooler.getInstance();
		
		lazyPrinter.addJob("First_Version_Report.pdf");
		lazyPrinter.resetPrintSpooler();		
		lazyPrinter.addJob("Second_Version_Report.pdf");		
		System.out.println("  * Job count using the LAZY Singleton spooler: " + lazyPrinter.countJobs());
		
		LazySingletonSpooler.getInstance().addJob("Third_Version_Report.pdf");		
		System.out.println("  * Job count using the LAZY Singleton spooler: " + LazySingletonSpooler.getInstance().countJobs());
		LazySingletonSpooler.getInstance().addJob("Presentation1_slides.pptx");
		LazySingletonSpooler.getInstance().addJob("Presentation2_slides.pptx");
		System.out.println("  * Job count using the LAZY Singleton spooler: " + LazySingletonSpooler.getInstance().countJobs());


		System.out.println("Testing EAGER Spooler ...");
		EagerSingletonSpooler.getInstance().addJob("First_Eager.doc");
		int totalJobs = EagerSingletonSpooler.getInstance().countJobs();
		System.out.println("  * Job count using the EAGER Singleton spooler: " + totalJobs);

		EnumSingletonSpooler.addJob("Enum_Tutorial.doc");
		totalJobs = EnumSingletonSpooler.jobNumber();
		System.out.println("  * Job count using the ENUM Singleton spooler: " + totalJobs);
	}
}