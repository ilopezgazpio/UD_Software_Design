package es.deusto.ingenieria.sd.strategy.game.character;

import es.deusto.ingenieria.sd.strategy.game.weapon.WeaponBehaviour;

//This class implements a Singleton Pattern
public class CharacterFactory {

	public enum Role {
		BARBARIAN,
		GOBLIN,
		KING,
		PALADIN;
	}
	
	private static CharacterFactory instance;
	
	private CharacterFactory() {		
	}
	
	public static CharacterFactory getInstance() {
		if (instance == null) {
			instance = new CharacterFactory();
		}
		
		return instance;
	}
	
	public Character createCharacter(Role role, WeaponBehaviour weapon) {
		switch (role) {
			case BARBARIAN:
				return new Barbarian(weapon);
			case GOBLIN:
				return new Goblin(weapon);
			case KING:
				return new King(weapon);
			case PALADIN:
				return new Paladin(weapon);
			default:
				return null;
		}
	}
}