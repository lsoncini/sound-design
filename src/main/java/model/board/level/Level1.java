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


	private final String content = "BBBBBBBBBB" +
								   "BPB.1.P.1B" +
								   "B1B.BBBB.B" +
								   "B.B1ABBB.B" +
								   "B.BBBBBB.B" +
								   "B..1.....B" +
								   "B.BBB.BBBB" +
								   "B.BMB.BBBB" +
								   "..B2....HB" +
								   "BBBBBBBBBB" ;

	private final String floor = "GGGGGGGGGG" +
 								 "GYGYYYYYYG" +
								 "GYGYGGGGYG" +
								 "GYGYYGGGYG" +
								 "GYGGGGGGYG" +
								 "GYYYYYYYYG" +
								 "GYGGGYGGGG" +
								 "GYGYGYGGGG" +
								 "YYGYYYYYYG" +
								 "GGGGGGGGGG" ;

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
					c = new Enemy2(3);
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
					c = new Sword(10);
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
		return new Rick(new HeroFighter(1));
	}

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
		return (new Point (8,0));
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
