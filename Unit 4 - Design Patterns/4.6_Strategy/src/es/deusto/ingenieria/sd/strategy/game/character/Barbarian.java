package es.deusto.ingenieria.sd.strategy.game.character;

import es.deusto.ingenieria.sd.strategy.game.weapon.WeaponBehaviour;

public class Barbarian extends Character 
{

	public Barbarian(WeaponBehaviour w) 
	{
		super(w);
	}
	
	@Override
	public void display() 
	{
		System.out.println("-> You are a strong, hulky barbarian!!");
	}
}