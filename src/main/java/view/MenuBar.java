package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import model.Game;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private Main main;
	
	public MenuBar(Main main){
		this.main = main;
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
			
		JMenuItem playAgain = new JMenuItem("Play Again");
		playAgain.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		playAgain.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				playAgain();
			}
		});
		
		JMenuItem mainMenu = new JMenuItem("Main Menu");
		mainMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mainMenu.setMnemonic(KeyEvent.VK_M);
		mainMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MainMenu.run();
				main.setVisible(false);
			}
		});
		
		JMenuItem credits = new JMenuItem("Credits");
		credits.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Credits.run(main);
			}
		});
		
		JMenuItem close = new JMenuItem("Close");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		file.add(playAgain);
		file.add(mainMenu);
		file.add(credits);
		file.add(close);

		this.add(file);
	}
	
	private void playAgain(){
		main.setVisible(false);
		Game newGame;
		try {
			newGame = main.restart();
			Main newMain = new Main(newGame);
			newMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			newMain.setVisible(true);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
