package main;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;

public class Window extends JFrame{

	
	public static Insets WINDOW_INSETS;
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 500;
	
	public Window() {
		super("cbozan/simple-game-engine");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(false);
		setLayout(null);
		setVisible(true);
		WINDOW_INSETS = this.getInsets();
		
		setSize(getWidth() + WINDOW_INSETS.left + WINDOW_INSETS.right, getHeight() + WINDOW_INSETS.top + WINDOW_INSETS.bottom);
		setLocationRelativeTo(null);
		
		this.add(new MainPanel());
		
	}
	
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Window();
			}
		});
	}
	
}
