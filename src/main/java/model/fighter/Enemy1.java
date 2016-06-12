package model.fighter;

import model.board.Content;
import model.element.Blood;
import model.fighter.level.EnemyLevel;

public class Enemy1 extends Enemy {
	
	private int moveCounter = 0;

	public Enemy1(int level) {
		super(new EnemyLevel(level, 1, 0.7));
	}

	@Override
	public Content contentLeft() {
		return new Blood();
	}

	@Override
	public void heroMoveListener() {
		this.moveCounter++;
		if(this.isAlive() && ((moveCounter % 2) == 0))
			this.heal(1);
	}

	public void injured(int value){
		super.injured(value);
		moveCounter=0;
	}	
}
