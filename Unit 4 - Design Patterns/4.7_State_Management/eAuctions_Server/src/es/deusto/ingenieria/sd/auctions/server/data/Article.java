package es.deusto.ingenieria.sd.auctions.server.data;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Article {
	private long number;
	private String title;
	private float initialPrice;
	private boolean active;
	private Category category;
	private User owner;
	private List<Bid> bids;
	
	public Article()
	{
		this.bids = new ArrayList<>();
	}
	
	public long getNumber()
	{
		return number;
	}
	
	public void setNumber(long number)
	{
		this.number = number;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public float getInitialPrice()
	{
		return initialPrice;
	}
	
	public void setInitialPrice(float initialPrice)
	{
		this.initialPrice = initialPrice;
	}
	
	public boolean isActive()
	{
		return active;
	}
	
	public void setActive(boolean active)
	{
		this.active = active;
	}
	
	public Category getCategory()
	{
		return category;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
	}
	
	public User getOwner()
	{
		return owner;
	}
	
	public void setOwner(User owner)
	{
		this.owner = owner;
	}
	
	public List<Bid> getBids()
	{
		return bids;
	}
	
	public void setBids(List<Bid> bids)
	{
		this.bids = bids;
	}
	
	public void addBid(Bid bid)
	{
		if (bid != null && !this.bids.contains(bid))
		{
			this.bids.add(bid);
		}
	}
	
	public Bid getHighestBid()
	{
		if (!this.bids.isEmpty())
		{
			Collections.sort(this.bids);		
			return this.bids.get(0);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj != null && obj.getClass().getName().equals(this.getClass().getName()))
		{
			return this.number == ((Article)obj).number;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
		StringBuffer result = new StringBuffer();
		
		result.append(this.title);
		//result.append(" - Owner: '");
		//result.append(this.owner.getNickname());
		result.append("' - Initial Price: ");
		result.append(numberFormatter.format(initialPrice));
		result.append(active ? " - Active " : " Sold");
		
		if (!this.bids.isEmpty())
		{
			result.append("\n  * Highest bid: ");
			result.append(this.getHighestBid());
		}
		
		return result.toString();
	}
}