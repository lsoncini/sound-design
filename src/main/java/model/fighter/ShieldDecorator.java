package model.fighter;

public class ShieldDecorator extends Hero {

	public ShieldDecorator(Fighter fighter){
		super(fighter);
	}
	
	public void injured(int value)
	{
		value *= 0.7;
		super.injured(value);
	}
}
