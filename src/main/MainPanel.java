package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;

import panels.*;
import shapes.*;

public class MainPanel extends JPanel implements MouseMotionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;
	public static int FPS = 25;
	private ShapePanel shapePanel;
	private ScenePanel scenePanel;
	private FeaturesPanel featuresPanel;
	
	int sceneX, sceneY, sceneWidth, sceneHeight;
	
	Image dragImage;
	ArrayList<MyShape> shapes = new ArrayList<MyShape>();
	
	
	int rX, rY, newX, newY;
	
	
	double x = 0, y = 0;
	
	public MainPanel() {
		
		setBounds(0, 0, Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
		this.setBackground(Color.red);
		setLayout(null);
		addMouseListener(this);
		addPanel();
		
	}
	
	public void addPanel() {
		
		shapePanel = new ShapePanel();
		shapePanel.setBounds(0, 0, 150, Window.WINDOW_HEIGHT);
		
		shapePanel.getCircle_label().addMouseListener(this);
		shapePanel.getPolygon_label().addMouseListener(this);
		shapePanel.getRectangle_label().addMouseListener(this);
		shapePanel.getTriangle_label().addMouseListener(this);
		
		shapePanel.getCircle_label().addMouseMotionListener(this);
		shapePanel.getPolygon_label().addMouseMotionListener(this);
		shapePanel.getRectangle_label().addMouseMotionListener(this);
		shapePanel.getTriangle_label().addMouseMotionListener(this);
		
		this.add(shapePanel);
		
		
		
		featuresPanel = new FeaturesPanel(shapes);
		featuresPanel.setBounds(Window.WINDOW_WIDTH - shapePanel.getWidth(), 0, 150, Window.WINDOW_HEIGHT);
		this.add(featuresPanel);
		
		sceneX = shapePanel.getWidth();
		sceneY = this.getY();
		sceneWidth = Window.WINDOW_WIDTH - (shapePanel.getWidth() + featuresPanel.getWidth());
		sceneHeight = this.getHeight();
		
		scenePanel = new ScenePanel(sceneX, sceneY, sceneWidth, sceneHeight, shapes);
		this.add(scenePanel);
		
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
//		for(MyShape shape : shapes)
//			shape.draw(g);
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		newX = ((JLabel)e.getSource()).getX() - (rX - e.getX());
		newY = ((JLabel)e.getSource()).getY() - (rY - e.getY());
		
		repaint();
	}


	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {

		rX = e.getX();
		rY = e.getY();
		
		if((e.getSource().getClass().equals(MyLabel.class)))
			dragImage = ((ImageIcon)((MyLabel)e.getSource()).getIcon()).getImage();		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource().getClass().equals(MyLabel.class) 
				&& e.getX() > scenePanel.getX() && e.getY() > scenePanel.getY() //
				&& e.getX() < scenePanel.getX() + scenePanel.getWidth()			// not enough
				&& e.getY() < scenePanel.getY() + scenePanel.getHeight() ) {	//
			
			int x = e.getX() - scenePanel.getX();
			int y = e.getY() - scenePanel.getY();
			
			
			
			switch(((MyLabel)e.getSource()).getName()) {
			
			// !!!!!! NOTE !!!!!!!
			/*accurately detect the relationship between the 
 				dropped point and the held point, and set the x and y position correctly */
			
				case "circle":
					shapes.add(new Circle(x, y, 64, 64));
					break;
				case "rectangle":
					shapes.add(new Rect(x, y, 64, 64));
					break;
				case "triangle":
					shapes.add(new Triangle(x, y, 64, 64));
					break;
				case "polygon":
					shapes.add(new Poly(x, y, 64, 64));
					break;
			}
			
			shapes.get(scenePanel.getCurrentShape()).setSelected(false);
			scenePanel.setCurrentShape(shapes.size() - 1);
			shapes.get(scenePanel.getCurrentShape()).setSelected(true);
			featuresPanel.setCurrentShape(scenePanel.getCurrentShape());
			
		}
		
		dragImage = null;
		revalidate();
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

	public ShapePanel getShapePanel() {
		return shapePanel;
	}

	public ScenePanel getScenePanel() {
		return scenePanel;
	}

	public FeaturesPanel getFeaturesPanel() {
		return featuresPanel;
	}
	
	
	
	
}
