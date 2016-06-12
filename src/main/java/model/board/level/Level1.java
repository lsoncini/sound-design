package model.board.level;

import java.awt.Point;

import model.board.Board;
import model.board.Content;
import model.board.cell.*;
import model.element.*;
import model.fighter.*;

public class Level1 extends Board {

	private Morty morty;

	/*
	 * C CACTUS
	 * B BUSH
	 * M MORTY
	 * 1..5 ENEMY 1..5
	 * V EVIL RICK
	 * H HEALTH BONUS
	 * P HEALTH POTION
	 * A ATTACK BONUS
	 * . nothing
	 */


	private final String content = "...CB....." +
								   "....M....." +
								   "....1....." +
								   "...2......" +
								   "...V......" +
								   "...H......" +
								   ".......P.." +
								   ".....H...." +
								   "..3...4..." +
								   "......5..." ;

	@Override
	protected void setContents() {

		for(int i = 0; i<(SIZE*SIZE); i++) {
			Content c = null;

			String character = Character.toString(content.charAt(i));

			switch (character) {
				case "C":
					c = new Cactus();
					break;
				case "B":
					c = new Bush();
					break;
				case "M":
					this.morty = new Morty();
					c = this.morty;
					break;
				case "1":
					c = new Enemy1(1);
					break;
				case "2":
					c = new Enemy2(1);
					break;
				case "3":
					c = new Enemy3(2);
					break;
				case "4":
					c = new Enemy4(1);
					break;
				case "5":
					c = new Enemy5(2);
					break;
				case "V":
					c = new EvilRick(3);
					break;
				case "H":
					c = new HealthBonus(10);
					break;
				case "P":
					c = new HealthPotion();
					break;
				case "A":
					c = new AttackBonus(10);
					break;
				default:
					break;
			}

			if (c != null)
				add(c, i/SIZE, i%SIZE);
		}
	}

	@Override
	protected Hero createHero() {
		return new Rick(new HeroFighter(2));
	}

	private final String floor = "OOOOOOOOOO" +
								 "OOOOOOOOOO" +
								 "OOOOOOOOOO" +
								 "OOOOOOOOOO" +
								 "OOOOOOOOOO" +
								 "OOOGGOOOOO" +
								 "OOOOOOOOOO" +
								 "OOOOYYYOOO" +
								 "RRRRRRRRRR" +
								 "OOOOOOOOOO" ;

	@Override
	public Cell getCellForPoint(int x, int y) {

		int index = x * SIZE + y;

		String character = Character.toString(floor.charAt(index));

		Cell returnCell = null;

		switch (character) {
			case "O":
				returnCell = new OrangeGrass();
				break;
			case "R":
				returnCell = new RedGrass();
				break;
			case "G":
				returnCell = new GreenGrass();
				break;
			case "Y":
				returnCell = new YellowGrass();
				break;
			default:
				returnCell = new Cell();
				break;
		}

		return returnCell;
	}
	
	private void add(Content c,int x, int y){
		g()[y][x].setContent(c);
		if(c instanceof Enemy)
			enemyList.add((Enemy)c);
	}
	
	@Override
	protected Point getHeroInitPosition() {
		return (new Point (8,8));
	}

	@Override
	public boolean gameOver() {
		return (!getHero().isAlive()) || playerWon();
	}

	@Override
	public boolean playerWon() {
		return this.morty.isFound();
	}
	
}
