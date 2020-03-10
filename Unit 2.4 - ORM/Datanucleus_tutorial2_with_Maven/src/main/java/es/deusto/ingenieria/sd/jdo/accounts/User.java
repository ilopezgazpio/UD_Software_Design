package es.deusto.ingenieria.sd.jdo.accounts;
import java.util.List;
import java.util.ArrayList;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class User 
{
	@PrimaryKey
	private String login;
	private String password;
	private String fullName;

	@Join
	@Persistent(mappedBy="user", dependentElement="true")
	private List<Account> accounts = new ArrayList<>();

	@Join
	private List<Address> addresses = new ArrayList<>();

	public User(String login, String password, String fullName) 
	{
		this.login = login;
		this.password = password;
		this.fullName = fullName;
	}

	public String getLogin() 
	{
		return login;
	}

	public String getPassword() 
	{
		return password;
	}

	public void addAccount(Account account) 
	{
		accounts.add(account);
	}

	public void removeAccount(Account account) 
	{
		accounts.remove(account);
	}

	public List<Account> getAccounts() 
	{
		return accounts;
	}

	public int getNumberOfAccounts() 
	{
		return accounts.size();
	}
	
	public void addAddress(Address address) 
	{
		addresses.add(address);
	}

	public void removeAddress(Address address) 
	{
		addresses.remove(address);
	}
	
	public void removeUserFromAddresses() 
	{
		for (Address a: addresses){
			a.removeUser(this);			
		}
	}
	
	public List<Address> getAddresses() 
	{
		return addresses;
	}

	public int getNumberOfAddresses() 
	{
		return addresses.size();
	}
	
	public String getFullName() 
	{
		return this.fullName;
	}
}