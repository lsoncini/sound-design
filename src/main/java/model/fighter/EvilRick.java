package model.fighter;

import model.board.Content;
import model.element.Sword;
import model.fighter.level.EnemyLevel;

public class EvilRick extends Enemy {

	public EvilRick(int level) {
		super(new EnemyLevel(level, 1.35, 1));
	}

	@Override
	public Content contentLeft() {
		return new Sword(this.getLevel().getValue());
	}

	@Override
	public void heroMoveListener() {
	}
}
