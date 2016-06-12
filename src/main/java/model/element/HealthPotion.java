package model.element;

import audio.AudioManager;
import model.board.Content;
import model.fighter.Fighter;

public class HealthPotion implements Content{
	
	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.healFull();
		AudioManager.play("heal");
		return hero;
	}

}