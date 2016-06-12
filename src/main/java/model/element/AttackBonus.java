package model.element;

import audio.AudioManager;
import model.board.Content;
import model.fighter.Fighter;

public class AttackBonus implements Valuable{

	private int value;
	
	public AttackBonus(int value){
		this.value = value;
	}
	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.stronger(getValue());
		AudioManager.play("heal");
		return hero;
	}

	@Override
	public int getValue() {	
		return value;
	}
}
