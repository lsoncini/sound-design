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
		AudioManager.playForLevel("fight");
		hero.injured(this.getStrength());
		if(hero.isAlive())
			this.injured(hero.getStrength());
		else {
			AudioManager.stop();
			AudioManager.play("death");
			try {
				Thread.sleep(2500);
				AudioManager.play("death_dialog");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
