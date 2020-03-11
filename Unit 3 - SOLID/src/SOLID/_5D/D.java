package SOLID._5D;

import java.util.ArrayList;
import java.util.List;
import org.javatuples.Triplet;
//http://www.java2s.com/Code/Jar/j/Downloadjavatuples12jar.htm

public class D
{
	/*  Dependency Inversion Principle
	 * 
	 * High-level modules should not depend on low-level modules
	 * Interfaces and abstractions should not depend on implementation details
	 * 
	 * */
	
	public static void main(String[] args)
	{
		Person parent =  new Person("John");
		Person child1 = new Person("Chris");
		Person child2 = new Person("Matt");
		
		Relationships relationships = new Relationships();
		relationships.addParentAndChild(parent, child1);
		relationships.addParentAndChild(parent, child2);

		// Bad call
		new Research(relationships);

		// Good call
        Relationships_independent relationshiops2 = new Relationships_independent();
        relationshiops2.addParentAndChild(parent, child1);
        relationshiops2.addParentAndChild(parent, child2);
        new Research_independent( relationshiops2);
	}
}

enum Relationship
{
	PARENT,
	CHILD,
	SIBLING
}


class Person
{
	public String name;
	
	public Person(String name)
	{
		this.name = name;
	}
}


class Relationships // low-level module (persistence level)
{
	private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
	
	public List<Triplet<Person, Relationship, Person>> getRelations()
	{
		return relations;
	}
	
	public void addParentAndChild(Person parent, Person child)
	{
		relations.add(new Triplet<>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<>(child, Relationship.CHILD, parent));
	}	
}


class Research // high-level module
{
	public Research(Relationships relationships) // This dependency is not OK
	{
		
		List < Triplet < Person, Relationship, Person> > relations = relationships.getRelations();

		relations.stream()
                .filter(x -> x.getValue0().name.equals("John") && x.getValue1() == Relationship.PARENT)
                .forEach
                        (
                                ch -> System.out.println("John has a child called " + ch.getValue2().name
                        )
        );
	}
}



interface RelationshipBrowser
{
	void findAllChildrenOf(String name);
}

class Relationships_independent implements RelationshipBrowser // low-level module (persistence level)
{
	@Override
	public void findAllChildrenOf(String name)
    {
		relations.stream()
                .filter(x -> x.getValue0().name.equals(name) && x.getValue1() == Relationship.PARENT)
                .forEach
                        (
                                ch -> System.out.println( name + " has a child called " + ch.getValue2().name
				)
                        );
	}
		

	private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
	
	public List<Triplet<Person, Relationship, Person>> getRelations()
	{
		return relations;
	}
	
	public void addParentAndChild(Person parent, Person child)
	{
		relations.add(new Triplet<>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<>(child, Relationship.CHILD, parent));
	}	
}


class Research_independent
{
	public Research_independent (RelationshipBrowser browser)
	{
		browser.findAllChildrenOf("John");
	}
}


