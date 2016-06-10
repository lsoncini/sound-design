package model.fighter;

import audio.AudioManager;
import model.board.Content;
import model.fighter.level.Level;
import model.fighter.GralFighter;

public abstract class Enemy extends GralFighter{

	public Enemy (Level level){
		this.level = level;
		initialize();
	}
	
	@Override
	public Content interact(Fighter hero) {
		AudioManager.play("fight");
		hero.injured(this.getStrength());
		if(hero.isAlive())
			this.injured(hero.getStrength());
		else AudioManager.play("death");
		if(this.isAlive())
			return this;
		else {
			hero.addExperience(this.level.getValue());
			return contentLeft();
		}
	}
	
	@Override
	public int getExperience(){
		return 0;
	}
	
	public abstract Content contentLeft();
	public abstract void heroMoveListener();
}
