package es.deusto.ingenieria.sd.strategy.game.weapon;

public class Crossbow implements WeaponBehaviour 
{

	@Override
	public void display() 
	{
		System.out.println("   * A damn pretty elf made crossbow");
	}

	@Override
	public void use() {
		System.out.println("   * You fire a bolt from your crossbow.");
	}
}