package es.deusto.ingenieria.sd.auctions.server.data;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bid implements Comparable<Bid>
{
	private long date;
	private float price;
	private Article article;
	private User user;

	public void setDate(Date date)
	{
		this.date = date.getTime();
	}

	public Date getDate()
	{
		return new Date(this.date);
	}

	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public float getPrice()
	{
		return this.price;
	}
	
	public Article getArticle()
	{
		return article;
	}

	public void setArticle(Article article)
	{
		this.article = article;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Override
	public int compareTo(Bid bid)
	{
		if (bid != null)
		{
			return Long.compare(this.date, bid.date);
		}
		else
		{
			return 0;
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj != null && obj.getClass().getName().equals(this.getClass().getName()))
		{
			Bid auxBid = (Bid)obj;
			
			return this.date == auxBid.date && this.price == auxBid.price && 
				   this.article.equals(auxBid.article) && this.user.equals(auxBid.user);
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		SimpleDateFormat dateFormatter = new SimpleDateFormat("DD-MMM-YYYY - hh:mm:ss");
		DecimalFormat numberFormatter = new DecimalFormat("0,##'�';-0,##'�'");  
		
		StringBuffer result = new StringBuffer();		
		result.append(dateFormatter.format(new Date(this.date)));
		result.append(" - ");
		result.append(this.user.getNickname());
		result.append(" - ");
		result.append(this.article.getNumber());
		result.append(numberFormatter.format(this.price));
		
		return result.toString();
	}
}