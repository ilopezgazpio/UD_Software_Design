package es.deusto.ingenieria.sd.strategy.game.character;

import es.deusto.ingenieria.sd.strategy.game.weapon.WeaponBehaviour;

public abstract class Character 
{

	private WeaponBehaviour weapon;

	public Character(WeaponBehaviour w) 
	{
		weapon = w;
	}

	public WeaponBehaviour getWeapon() 
	{
		return weapon;
	}

	public void setWeapon(WeaponBehaviour w) 
	{
		weapon = w;
		System.out.println("-> Let's change our weapon ...");
	}

	public void fight() 
	{
		weapon.use();
	}

	public abstract void display();
}