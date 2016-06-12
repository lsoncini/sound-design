package model.fighter;

import model.board.Content;
import model.element.Blood;
import model.fighter.level.EnemyLevel;

public class Enemy2 extends Enemy {

	public Enemy2(int level) {
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