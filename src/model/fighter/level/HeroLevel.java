package model.fighter.level;

public class HeroLevel extends Level{

	public HeroLevel(int value, int maxLevel) {
		super(value, maxLevel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getMaxHealth() {
		return (10 * getValue());
	}

	@Override
	public int getStrength() {
		return (5 * getValue());
	}

	@Override
	public int getMaxExperience() {
		return (5 * getValue());
	}
}
