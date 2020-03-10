package es.deusto.ingenieria.sd.jdo.accounts;

import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Account 
{
	private String bankName;
    private double balance;
    private User user;
	private Address address;
	private Date openDate;

	public Account(String bankName, double balance, Address address) 
	{
		this.bankName = bankName;
        this.balance = balance;
		this.address = address;
		this.openDate = new Date();
    }

	public String getBankName() 
	{
		return this.bankName;
	}
	
	public Date getOpenDate() 
	{
		return this.openDate;
	}
	
    public double getBalance() 
    {
        return this.balance;
    }

    public User getUser() 
    {
        return user;
    }

    public void setUser(User user) 
    {
        this.user = user;
    }

    public String toString() 
    {
        return this.bankName + " ($ " + balance + ") // " + user.getFullName() + " // " + address;
    }
	
	public void credit(double money) 
	{
		this.balance += money;
	}
	
	public void debit(double money) 
	{
		this.balance -= money;
	}
}