package model.fighter;

import model.board.Content;
import model.element.Blood;
import model.fighter.level.EnemyLevel;

public class Serpent extends Enemy {

	public Serpent(int level) {
		super(new EnemyLevel(level, 1, 1));
	}

	@Override
	public Content contentLeft() {
		return new Blood();
	}

	@Override
	public void heroMoveListener() {
	}
}