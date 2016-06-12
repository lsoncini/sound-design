package model.element;

import model.board.Content;
import model.fighter.Fighter;
import model.fighter.ShieldDecorator;

public class Shield implements Content {

	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		hero = new ShieldDecorator(hero);
		return hero;
	}
}