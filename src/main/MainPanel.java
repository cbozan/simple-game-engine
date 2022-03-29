package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import panels.*;

public class MainPanel extends JPanel implements MouseMotionListener{
	
	ShapePanel shapePanel;
	ScenePanel scenePanel;
	FeaturesPanel featuresPanel;
	double x = 0, y = 0;
	
	public MainPanel() {
		
		setBounds(0, 0, Window1.WINDOW_WIDTH, Window1.WINDOW_HEIGHT);
		this.setBackground(Color.red);
		setLayout(null);
		addMouseMotionListener(this);
		
		featuresPanel = new FeaturesPanel();
		featuresPanel.setBounds(0, 0, 150, Window1.WINDOW_HEIGHT);
		featuresPanel.setBackground(Color.WHITE);
		this.add(featuresPanel);
		
		
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval((int)x, (int)y, 80, 80);
		
		
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println(x++);
		repaint();
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
