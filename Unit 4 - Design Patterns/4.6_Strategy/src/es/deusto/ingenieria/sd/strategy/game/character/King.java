package es.deusto.ingenieria.sd.strategy.game.character;

import es.deusto.ingenieria.sd.strategy.game.weapon.WeaponBehaviour;

public class King extends Character 
{

	public King(WeaponBehaviour w) 
	{
		super(w);
	}

	@Override
	public void display() 
	{
		System.out.println("-> You are a rightous proud king.");
	}
}