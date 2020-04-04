package es.deusto.ingenieria.sd.strategy.game.weapon;

public class Knife implements WeaponBehaviour 
{
	@Override
	public void display() 
	{
		System.out.println ("   * A very dull knife.");
	}

	@Override
	public void use() 
	{
		System.out.println("   * You stab wildly with your knife.");
	}
}