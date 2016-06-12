package view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import audio.AudioManager;
import model.Game;
import model.board.level.Level1;
import model.board.level.Level2;
import model.board.level.Level3;

public class MainMenu {

	private static JFrame mainFrame;

	
	public static void run() {
		mainFrame = new JFrame("Rick and Morty: Where's Morty? - Developed by TEAM RAPTOR");
		mainFrame.setLayout(null);
		mainFrame.setResizable(false);
		try {
			mainFrame.setIconImage(ImageUtils.loadImage("logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainFrame.setSize(500, 700);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.BLACK);
		mainFrame.setContentPane(contentPanel);
		
		try {
			BufferedImage title = (BufferedImage) ImageUtils.loadImage("title.jpg");
			JLabel titleLabel = new JLabel(new ImageIcon(title));
			contentPanel.add(titleLabel);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedImage buttonIconLevel1;
		try {
			buttonIconLevel1 = (BufferedImage) ImageUtils.loadImage("level1.jpg");
			JButton level1Button = new JButton(new ImageIcon(buttonIconLevel1));
			level1Button.addMouseListener(levelMouseListener(Level1.class));
			level1Button.setBorder(BorderFactory.createEmptyBorder());
			level1Button.setContentAreaFilled(false);
			contentPanel.add(level1Button);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BufferedImage buttonIconLevel2;
		try {
			buttonIconLevel2 = (BufferedImage) ImageUtils.loadImage("level2.jpg");
			JButton level2Button = new JButton(new ImageIcon(buttonIconLevel2));
			level2Button.addMouseListener(levelMouseListener(Level2.class));
			level2Button.setBorder(BorderFactory.createEmptyBorder());
			level2Button.setContentAreaFilled(false);
			contentPanel.add(level2Button);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BufferedImage buttonIconLevel3;
		try {
			buttonIconLevel3 = (BufferedImage) ImageUtils.loadImage("level3.jpg");
			JButton level3Button = new JButton(new ImageIcon(buttonIconLevel3));
			level3Button.addMouseListener(levelMouseListener(Level3.class));
			level3Button.setBorder(BorderFactory.createEmptyBorder());
			level3Button.setContentAreaFilled(false);
			contentPanel.add(level3Button);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mainFrame.setVisible(true);
		AudioManager.play("menu");
	}

	private static MouseListener levelMouseListener(final Class<?> levelClass) {

		return new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				Main main;
				try {
					AudioManager.stop();
					AudioManager.play("menuButton");
					main = new Main(new Game(levelClass));
					main.setVisible(true);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mainFrame.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
	public static void main(String[] args) {
		MainMenu.run();
	}
}