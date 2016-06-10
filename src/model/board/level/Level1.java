package model.board.level;

import java.awt.Point;

import model.board.Board;
import model.board.Content;
import model.element.AttackBonus;
import model.element.HealthBonus;
import model.element.HealthPotion;
import model.element.Shield;
import model.element.Sword;
import model.element.Wall;
import model.fighter.Enemy;
import model.fighter.Goblin;
import model.fighter.Golem;
import model.fighter.Serpent;

public class Level1 extends Board{
	
	@Override
	protected void setContents() {
		setWalls();
		setEnemies();
		setMisc();
	}

	protected void setWalls()
	{
		add (new Wall(),11,10); add (new Wall(),2,9);
		add (new Wall(),9,9);  add (new Wall(),1,9);
		add (new Wall(),9,10); add (new Wall(),7,8);
		add (new Wall(),9,11); add (new Wall(),7,7);
		add (new Wall(),7,9);  add (new Wall(),7,3);
		add (new Wall(),7,10); add (new Wall(),6,8);
		add (new Wall(),7,11); add (new Wall(),5,8);
		add (new Wall(),6,10); add (new Wall(),4,8);
		add (new Wall(),5,10); add (new Wall(),3,7);
		add (new Wall(),4,10); add (new Wall(),7,4);
		add (new Wall(),3,10); add (new Wall(),7,5);
		add (new Wall(),2,10); add (new Wall(),7,7);
		add (new Wall(),8,7);  add (new Wall(),8,5);
		add (new Wall(),9,7);  add (new Wall(),8,3);
		add (new Wall(),9,5);  add (new Wall(),5,6);
		add (new Wall(),9,4);  add (new Wall(),5,5);
		add (new Wall(),9,3);  add (new Wall(),5,4);
		add (new Wall(),5,3);  add (new Wall(),5,2);
		add (new Wall(),3,6);  add (new Wall(),11,2);
		add (new Wall(),3,5);  add (new Wall(),10,1);
		add (new Wall(),3,4);  add (new Wall(),11,9);
		add (new Wall(),3,3);  add (new Wall(),8,2);
		add (new Wall(),3,2);  add (new Wall(),8,1);
		add (new Wall(),8,0);  add (new Wall(),5,1);
		add (new Wall(),6,1);  add (new Wall(),1,0);
		add (new Wall(),2,0);  add (new Wall(),1,9);
		add (new Wall(),1,8);  add (new Wall(),1,5); 
		add (new Wall(),1,7);  add (new Wall(),1,4);
		add (new Wall(),1,6);  add (new Wall(),1,3);
		add (new Wall(),3,0);  add (new Wall(),1,1);
	}
	
	protected void setEnemies()
	{
		add (new Golem(2),10,9);
		add (new Golem(4),10,11);
		add (new Goblin (1),8,9);
		add (new Goblin (2),3,8);
		add (new Serpent(1),9,8);
		add (new Serpent(4),5,9);
		add (new Serpent(1),11,5);
		add (new Serpent(1),11,0);
		add (new Goblin(1),10,5);
		add (new Goblin(1),10,0);
		add (new Golem(2),9,6);
		add (new Golem(7),6,11);
		add (new Goblin(3),4,5);
		add (new Goblin(3),0,7);
		add (new Serpent(5),0,1);
		add (new Serpent(6),0,9);
	}
	
	protected void setMisc()
	{
		add (new HealthBonus(20),3,9);
		add (new Shield(),11,11);
		add (new Shield(),6,9);
		add (new Shield(),0,0);
		add (new Sword(100),8,4);
		add (new Sword(10),10,10);
		add (new AttackBonus(10),11,1);
		add (new HealthPotion(),0,11);
		add (new Sword(10),6,0);
	}
	
	private void add(Content c,int x, int y){
		g()[y][x].setContent(c);
		if(c instanceof Enemy)
			enemyList.add((Enemy)c);
	}
	
	@Override
	protected Point getHeroInitPosition() {
		return (new Point (8,11));
	}

	@Override
	public boolean gameOver() {
		return (!getHero().isAlive()) || playerWon();
	}

	@Override
	public boolean playerWon() {
		boolean enemiesAlive = false;
		for(Enemy e : enemyList)
			enemiesAlive |= e.isAlive();
 		return !enemiesAlive;
	}
	
}
