package es.deusto.ingenieria.sd.strategy.game.character;

import es.deusto.ingenieria.sd.strategy.game.weapon.WeaponBehaviour;

public class Goblin extends Character 
{

	public Goblin(WeaponBehaviour w) 
	{
		super(w);
	}

	@Override
	public void display() 
	{
		System.out.println("-> You are a nasty evil goblin.");
	}
}