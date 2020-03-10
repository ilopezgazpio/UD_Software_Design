package es.deusto.ingenieria.sd.jdo.accounts;

import java.util.List;
import java.util.ArrayList;


import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Join;

@PersistenceCapable
public class Address 
{
	private String street;
	private String city;
	private String country;
	private String postcode;

	@Join
	private List<User> users = new ArrayList<>();
	
    public Address(String street, String city, String country, String postcode) 
    {
		this.street = street;
        this.city = city;
		this.country = country;
		this.postcode = postcode;
    }
    
    public String getStreet() 
    {
		return street;
	}

	public void setStreet(String street) 
	{
		this.street = street;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public String getPostcode() 
	{
		return postcode;
	}

	public void setPostcode(String postcode) 
	{
		this.postcode = postcode;
	}

	public void setUsers(List<User> users) 
	{
		this.users = users;
	}

	public void addUser(User user) 
	{
		users.add(user);
	}

	public void removeUser(User user) 
	{
		users.remove(user);
	}

	public List<User> getUsers() 
	{
		return users;
	}

	public int getNumberOfUsers() 
	{
		return users.size();
	}

    public String toString() 
    {
        return street + " - " + city + " (" + postcode + ") [" + country + "]";
    }
}