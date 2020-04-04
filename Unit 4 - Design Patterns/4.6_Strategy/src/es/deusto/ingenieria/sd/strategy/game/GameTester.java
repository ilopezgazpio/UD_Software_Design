package es.deusto.ingenieria.sd.strategy.game;

import es.deusto.ingenieria.sd.strategy.game.character.Character;
import es.deusto.ingenieria.sd.strategy.game.character.CharacterFactory;
import es.deusto.ingenieria.sd.strategy.game.character.CharacterFactory.Role;
import es.deusto.ingenieria.sd.strategy.game.weapon.Crossbow;
import es.deusto.ingenieria.sd.strategy.game.weapon.Knife;
import es.deusto.ingenieria.sd.strategy.game.weapon.Sword;

public class GameTester 
{

	public static void main(String[] args) 
	{		
		// Create a Character using the Factory
		Character character = CharacterFactory.getInstance().createCharacter(Role.PALADIN, new Sword());
		character.display();
		character.fight();

		// Change the Paladin's weapon at run-time.
		character.setWeapon(new Crossbow());
		character.fight();
		
		// Another Character
		character = CharacterFactory.getInstance().createCharacter(Role.GOBLIN, new Knife()); 
		character.display();
		character.fight();

		// Change the Goblin's weapon at run-time.
		character.setWeapon(new Sword());
		character.fight();
	}
}