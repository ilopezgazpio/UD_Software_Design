package org.datanucleus.samples.jdo.tutorial;

import java.util.HashSet;
import java.util.Set;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Inventory
{
	@PrimaryKey
	String name = null;
    Set<Product> products = new HashSet<Product>();

    public Inventory(String name)
    {
        this.name = name;
    }

    public Set<Product> getProducts()
    {
        return products;
    }
}