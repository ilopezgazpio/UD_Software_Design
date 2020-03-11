package SOLID._4I;

public class I
{

	/*  Interface Segregation
	 * 
	 * Better to extend functionality by extending interfaces rather than inheritance
	 * Better to exted functionality by extending small interfaces rather than huge interfaces
	 * 
	 * */
}

class Document
{
	
}


interface Machine
{
	void print(Document d);
	void fax(Document d);
	void scan (Document d);
}


class MultiFunctionPrinter implements Machine
{

	@Override
	public void print(Document d) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fax(Document d) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan(Document d) 
	{
		// TODO Auto-generated method stub
		
	}
	
}


class OldFashionedPrinter implements Machine
{

	@Override
	public void print(Document d) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fax(Document d) 
	{
		// ????? -> This is an error
		
	}

	@Override
	public void scan(Document d) 
	{
		// ????? -> This is an error
		
	}
	
	// Methods we do not want to implement could be handled with exceptions, but is not optimal
	
}





// Solution -> Segregate the interface

interface Printer
{
	void print (Document d);
}

interface Scanner
{
	void scan (Document d);
}



class JustAPrinter implements Printer
{

	@Override
	public void print(Document d) 
	{
		// TODO Auto-generated method stub
		
	}	
}


class Photocopier implements Printer, Scanner
{

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}


interface MultiFunctionDevice extends Printer, Scanner {}



class MultiFunctionMachine implements MultiFunctionDevice
{

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}
