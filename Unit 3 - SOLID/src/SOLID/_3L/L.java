package SOLID._3L;

public class L
{
	/* *
	 * Liskov Substitution Principle
	 * 
	 * Subclasses should not have any issue to be used as casted to their parent class types
	 * 
	 * */
	
	
	static void useIt(Rectangle r)
	{
		int width = r.getWidth();
		r.setHeight(10);
		// area = width * 10
		System.out.println("Expected area of " + (width * 10) + ", got " + r.getArea() );
	}

	public static void main(String[] args)
	{
		Rectangle rc = new Rectangle(2,3);
		useIt(rc); // OK
		
		Rectangle sq = new Square(); 
		sq.setWidth(5);
		useIt(sq); // KO
	}
	
}


class Rectangle
{
	protected int width, height;
	
	public Rectangle()
	{ }
	
	public Rectangle(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public int getArea()
	{
		return width * height;
	}
	
	@Override
	public String toString()
	{
		return	"Rectangle { " +
				"width = " + width +
				", height = " + height + " } ";
	}
}


class Square extends Rectangle
{
	public Square() {}
	
	public Square(int size)
	{
		width = height = size;
	}
	
	@Override
	public void setWidth (int width)
	{
		super.setWidth(width);
		super.setHeight(width); // Esta linea viola nuestra condicion de Liskov
	}
	
	@Override
	public void setHeight(int height)
	{
		super.setHeight(height);
		super.setWidth(height); // Esta linea viola nuestra condicion de Liskov
	}
}


// Solucion mediante el patron de diseño Factory

class RectangleFactory 
{
	public static Rectangle newRectangle (int width, int height)
	{
		return new Rectangle(width, height);
	}
	
	public static Rectangle newSquare(int side)
	{
		return new Rectangle(side, side);
	}
}

