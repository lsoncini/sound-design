package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

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
	    this.setSize(mainPanel.getWidth(), mainPanel.getHeight() + 22);
	    this.setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

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
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Main mainWindow = new Main(new Game(Level3.class));
		mainWindow.setVisible(true);
	}

}

