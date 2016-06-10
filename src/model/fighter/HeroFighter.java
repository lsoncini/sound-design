package model.fighter;

import model.board.Content;
import model.fighter.level.HeroLevel;

public class HeroFighter extends GralFighter{

	public HeroFighter(){
		level = new HeroLevel(1,10);
		initialize();
	}
	
	@Override
	public Content interact(Fighter hero) {
		return hero;
	}
}
