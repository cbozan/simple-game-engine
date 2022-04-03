package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import panels.*;
import shapes.*;

public class MainPanel extends JPanel implements MouseMotionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;
	private ShapePanel shapePanel;
	private ScenePanel scenePanel;
	private FeaturesPanel featuresPanel;
	
	int sceneX, sceneY, sceneWidth, sceneHeight;
	
	Image dragImage;
	ArrayList<MyShape> shapes = new ArrayList<MyShape>();
	
	
	int rX, rY, newX, newY;
	
	
	double x = 0, y = 0;
	
	public MainPanel() {
		
		setBounds(0, 0, Window1.WINDOW_WIDTH, Window1.WINDOW_HEIGHT);
		this.setBackground(Color.red);
		setLayout(null);
		addMouseListener(this);
		addPanel();
		
	}
	
	public void addPanel() {
		
		shapePanel = new ShapePanel();
		shapePanel.setBounds(0, 0, 150, Window1.WINDOW_HEIGHT);
		
		shapePanel.getCircle_label().addMouseListener(this);
		shapePanel.getPolygon_label().addMouseListener(this);
		shapePanel.getRectangle_label().addMouseListener(this);
		shapePanel.getTriangle_label().addMouseListener(this);
		
		shapePanel.getCircle_label().addMouseMotionListener(this);
		shapePanel.getPolygon_label().addMouseMotionListener(this);
		shapePanel.getRectangle_label().addMouseMotionListener(this);
		shapePanel.getTriangle_label().addMouseMotionListener(this);
		
		this.add(shapePanel);
		
		
		featuresPanel = new FeaturesPanel();
		featuresPanel.setBounds(Window1.WINDOW_WIDTH - shapePanel.getWidth(), 0, 150, Window1.WINDOW_HEIGHT);
		this.add(featuresPanel);
		
		// move to scene panel 
		sceneX = shapePanel.getWidth();
		sceneY = this.getY();
		sceneWidth = Window1.WINDOW_WIDTH - (shapePanel.getWidth() + featuresPanel.getWidth());
		sceneHeight = this.getY();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if(dragImage != null)
			g.drawImage(dragImage, newX, newY, null);
		//g.drawRect(shapePanel.getWidth() + 2, shapePanel.getY() + 2, Window1.WINDOW_WIDTH - shapePanel.getWidth() - 4, Window1.WINDOW_HEIGHT - 4);
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(MyShape shape : shapes)
			shape.draw(g);
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		newX = ((JLabel)e.getSource()).getX() - (rX - e.getX());
		newY = ((JLabel)e.getSource()).getY() - (rY - e.getY());
		
		repaint();
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).intersects(e.getX(), e.getY(), 1, 1)) {
				shapes.get(i).setBorderColor(Color.BLUE);
				break;
			}
			System.out.println(shapes.get(i).intersects(e.getX(), e.getY(), 2, 2) + ", " + shapes.get(i).isEmpty() + ", " + shapes.get(i).getWidth() + ", " + shapes.get(i).getHeight());
			
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {

		rX = e.getX();
		rY = e.getY();
		
		if((e.getSource().getClass().equals(MyLabel.class)))
			dragImage = ((ImageIcon)((MyLabel)e.getSource()).getIcon()).getImage();		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource().getClass().equals(MyLabel.class)) {
			switch(((MyLabel)e.getSource()).getName()) {
			
				case "circle":
					shapes.add(new Circle(e.getX(), e.getY() + 50, 100, 100));
					shapes.get(shapes.size() - 1).setBorderWidth(8);
					
					break;
				case "rectangle":
					shapes.add(new Rect(e.getX(), e.getY() + 50, 100, 100));
					shapes.get(shapes.size() - 1).setBorderWidth(8);
					break;
				case "triangle":
					shapes.add(new Triangle(e.getX(), e.getY() + 50, 30, 30));
					break;
				case "polygon":
					shapes.add(new Poly(e.getX(), e.getY() + 50, 30, 30));
					break;
			}
		}
		//System.out.println(shapes.size());
		dragImage = null;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
