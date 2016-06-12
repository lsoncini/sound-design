package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;

import audio.AudioManager;
import model.Game;
import model.board.Move;
import model.board.level.Level1;
import model.board.level.Level2;
import model.board.level.Level3;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	private MainPanel mainPanel;
	
	public Main(Game game) {
		super("Rick and Morty: " + game.getLevelName() + " - Developed by TEAM RAPTOR");
		
		this.game = game;
		
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(true);
	    Toolkit toolkit = getToolkit();
	    Dimension size = toolkit.getScreenSize();
	    this.setContentPane(mainPanel = new MainPanel(game));
	    this.setSize(mainPanel.getWidth(), mainPanel.getHeight() + 60);
	    this.setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
	    this.setJMenuBar(new MenuBar(this));
	    try {
			this.setIconImage(ImageUtils.loadImage("logo.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch ( e.getKeyCode() ) {
				case KeyEvent.VK_UP:
					Main.this.game.onMove(Move.UP); break;
				case KeyEvent.VK_DOWN:
					Main.this.game.onMove(Move.DOWN); break;
				case KeyEvent.VK_LEFT:
					Main.this.game.onMove(Move.LEFT); break;
				case KeyEvent.VK_RIGHT:
					Main.this.game.onMove(Move.RIGHT); break;
				}
				mainPanel.refresh();
			}
		});
	}
	
	public Game restart() throws InstantiationException, IllegalAccessException{
		int levelNumber = game.getLevelNumber();
		switch (levelNumber) {
		case 1:
			return new Game(Level1.class);
		case 2:
			return new Game(Level2.class);
		default:
			return new Game(Level3.class);
		}
	}
	
	public void resume(){
		AudioManager.playForLevel("gameStart");
	}

}

