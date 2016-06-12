package model.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import audio.AudioManager;


import model.board.cell.Cell;
import model.board.cell.OrangeGrass;
import model.element.Morty;
import model.fighter.Enemy;
import model.fighter.Hero;
import model.fighter.HeroFighter;

public abstract class Board {
	
	public static final int SIZE = 10;
	
	private Cell[][] g = new Cell[SIZE][SIZE];
	private Point heroPosition;
	protected List<Enemy> enemyList = new ArrayList<Enemy>();
	
	public Board() {
		initialize();
		AudioManager.play("gameStart");
	}
	
	public void initialize() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				g[y][x] = getCellForPoint(x, y);
			}
		}
		
		setContents();
		heroPosition = getHeroInitPosition();
		g()[heroPosition.y][heroPosition.x].setContent(createHero());
		cleanFog(heroPosition);
	}

	public void heroMove(Move move) {
		if (!gameOver()) {
			Point newPosition = new Point(heroPosition.x + move.getX(), heroPosition.y + move.getY());
	
			if (newPosition.x >= 0 && newPosition.y >= 0 && newPosition.x < SIZE && newPosition.y < SIZE) {
				if (g[newPosition.y][newPosition.x].canWalkOver()) {
					g[newPosition.y][newPosition.x].onWalk(getHero());
					g[heroPosition.y][heroPosition.x].removeContent();
					heroPosition = newPosition;
					heroMoveListener();
					cleanFog(heroPosition);
					AudioManager.play("general");
				} else if (g[newPosition.y][newPosition.x].canInteract()) {
					g[newPosition.y][newPosition.x].interact(getHero());
				}
			}
		}
	}
	
	private void cleanFog(Point p){
		for (int i = p.y-1; i <= p.y+1; i++) {
			for (int j = p.x-1; j <= p.x+1 ; j++) {
				if (i>=0 && i<SIZE && j>=0 && j<SIZE) {
					if (g[i][j].hasFog()) {
						g[i][j].removeFog();
						getHero().heal(getHero().getLevel().getValue());
					}
				}
			}
		}
	}
	
	public Point getHeroPosition(){
		return heroPosition;
	}

	public abstract Cell getCellForPoint(int x, int y);
	
	public Cell get(int x, int y) {
		return g[y][x];
	}
	
	public Hero getHero() {
		return (Hero) g[heroPosition.y][heroPosition.x].getContent();
	}

	protected Cell[][] g(){
		return g;
	}
	
	protected void heroMoveListener(){
		for(Enemy e : enemyList)
			e.heroMoveListener();
	}
	
	protected abstract void setContents();

	protected abstract Hero createHero();

	protected abstract Point getHeroInitPosition();
	
	public abstract boolean gameOver();
	
	public abstract boolean playerWon();
}
