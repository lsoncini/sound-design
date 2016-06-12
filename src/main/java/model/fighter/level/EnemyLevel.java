package model.fighter.level;

public class EnemyLevel extends Level{
	
	private final double S, F;
	
	public EnemyLevel(int value, double s, double f) {
		super(value, 10);
		this.F = f;
		this.S = s;
	}

	@Override
	public int getMaxHealth() {
		return (int)Math.floor((Math.pow(getValue()+3,2)-10)*S);
	}

	@Override
	public int getStrength() {
		return (int)Math.floor((Math.pow(getValue(),2)+5*getValue())*0.5*F);
	}

	@Override
	public int getMaxExperience() {
		return (5 * getValue());
	}
}