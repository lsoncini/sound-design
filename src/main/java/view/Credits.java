package view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import audio.AudioManager;

public class Credits {

	private static JFrame mainFrame;

	public static void run(Main previous) {
		mainFrame = new JFrame("Credits");
		mainFrame.setLayout(null);
		mainFrame.setResizable(false);
		try {
			mainFrame.setIconImage(ImageUtils.loadImage("logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainFrame.setSize(600, 600);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				AudioManager.stop();
				mainFrame.setVisible(false);
				previous.resume();
			}
		});
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.BLACK);
		mainFrame.setContentPane(contentPanel);

		try {
			BufferedImage logo = (BufferedImage) ImageUtils.loadImage("logo.png");
			JLabel logoLabel = new JLabel(new ImageIcon(logo));
			contentPanel.add(logoLabel);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			BufferedImage credits = (BufferedImage) ImageUtils.loadImage("credits.png");
			JLabel creditsLabel = new JLabel(new ImageIcon(credits));
			contentPanel.add(creditsLabel);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AudioManager.stop();
		mainFrame.setVisible(true);
		AudioManager.play("getschwifty");
	}
}
