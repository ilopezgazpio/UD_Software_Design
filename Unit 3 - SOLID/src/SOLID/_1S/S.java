package SOLID._1S;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class S
{
	/* *
	 * SINGLE RESPONSIBILITY
	 * =====================
	 * Each class should respond to one demand
	 * 
	 * */


    // En la clase Journal los metodos relativos a la persistencia rompen el principio de la responsabilidad unica
    // Estos metodos deberian estar abstraidos en otra clase fuera de Journal
	
	public static void main(String [] args) throws IOException
    {
		Journal j = new Journal();
		
		j.addEntry("Entry 1");
		j.addEntry("Entry 2");

		System.out.println(j);
		
		Persistence p = new Persistence();
		String filename = "journal.txt";
		p.saveToFile(j, filename, true);

		Runtime.getRuntime().exec("gedit " + filename);	
	}
		
}

class Journal
{
	private final List<String> entries = new ArrayList<>();
	private static int count = 0;
	
	public void addEntry(String text)
	{
		entries.add("" + (++count) + ": " + text);
	}
	
	public void removeEntry(int index)
	{
		entries.remove(index);
	}
	
	public void save(String filename) throws FileNotFoundException
	{
		try (PrintStream out = new PrintStream(filename))
		{
			out.println(toString());
		}
	}
	
	public void load (String filename) 
	{
		
	}
	
	public void load(URL url) 
	{
		
	}
	
	@Override
	public String toString()
    {
		return String.join(System.lineSeparator(), entries);
	}
	
}

class Persistence 
{
	public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException 
	{
		if (overwrite || new File(filename).exists()) 
		{
			try (PrintStream out = new PrintStream(filename))
			{
				out.println(journal.toString());
			}
		}
	}
	
	public Journal load(String filename) 
	{
		return null;
	}
	
	public Journal load(URL url)
	{
		return null;
	}
}
