package es.deusto.ingenieria.sd.strategy.game.character;

import es.deusto.ingenieria.sd.strategy.game.weapon.WeaponBehaviour;

public class Paladin extends Character 
{

	public Paladin(WeaponBehaviour w) 
	{
		super(w);
	}
	
	@Override
	public void display() 
	{
		System.out.println("-> You are a holy paladin, slayer of evil.");
	}
}