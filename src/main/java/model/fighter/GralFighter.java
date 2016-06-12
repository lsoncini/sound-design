package model.fighter;

import model.board.Content;
import model.fighter.level.Level;

public abstract class GralFighter implements Fighter{

	protected int health;
	protected int strength;
	protected int experience;
	protected Level level;
	
	protected void initialize(){
		healFull();
		this.strength = level.getStrength();
		this.experience = 0;
	}
	
	@Override
	public boolean canWalkOver() {
		return false;
	}
					
	@Override
	public abstract Content interact(Fighter hero);
										
	@Override	
	public boolean isAlive() {
		return (getHealth() > 0);
	}	

	@Override
	public void injured(int value) {
		if ((getHealth() - value) > 0)
			this.health -= value;
		else
			this.health = 0;
	}
	
	@Override
	public void heal(int value) {
		if ((getHealth() + value) < getMaxHealth())
			this.health += value;
		else healFull();
	}

	@Override
	public void healFull() {
		this.health = getMaxHealth();
	}

	@Override
	public int getStrength() {
		return this.strength;
	}

	@Override
	public void stronger(int value) {
		this.strength += value;		
	}

	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public int getMaxHealth() {
		return level.getMaxHealth();
	}

	@Override
	public Level getLevel() {
		return level;
	}

	@Override
	public boolean hasMaxLevel() {
		return (level.getMaxLevel() == level.getValue());
	}

	@Override
	public void addExperience(int value) {
		if(getExperience() + value < getMaxExperience())
			this.experience += value;
		else if (getLevel().getValue() < getLevel().getMaxLevel())
		{
			getLevel().levelUp();
			this.initialize();
		}
	}

	@Override
	public int getExperience() {
		return this.experience;
	}

	@Override
	public int getMaxExperience() {
		return level.getMaxExperience();
	}

}
