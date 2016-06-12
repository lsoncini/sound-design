package model;

import java.awt.Point;

import audio.AudioManager;
import model.board.Board;
import model.board.cell.Cell;
import model.board.Move;
import model.fighter.Hero;

public class Game {
	
	private Board board;
	
	public <T> Game(Class<T> boardClass) throws InstantiationException, IllegalAccessException {
		AudioManager.stop();
		this.board = (Board)boardClass.newInstance();
		AudioManager.loopForLevel("music");;
	}
	
	public void onMove(Move move) {
		board.heroMove(move);
	}
	
	public int getBoardSize() {
		return Board.SIZE;
	}
	
	public Point getHeroPosition() {
		return board.getHeroPosition();
	}
	
	public Cell get(int x, int y) {
		return board.get(x, y);
	}
	
	public Hero getHero() {
		return board.getHero();
	}
	
	public boolean isOver() {
		return board.gameOver();
	}
	
	public boolean playerWon() {
		return board.playerWon();
	}
	
	public String getLevelName(){
		return board.levelName();
	}
	
	public int getLevelNumber(){
		return board.levelNumber();
	}
	
}
