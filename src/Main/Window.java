package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Shapes.Circle;
import Shapes.MyShape;
import Shapes.Poly;
import Shapes.Rect;
import Shapes.Triangle;

public class Window extends JFrame implements MouseListener{
	
	
	public static Insets WINDOW_INSETS;
	
	public final int WINDOW_WIDTH = 800;
	public final int WINDOW_HEIGHT = 600;
	
	public int windowBoundsX;
	public int windowBoundsY;
	public int windowBoundsWidth;
	public int windowBoundsHeight;
	
	LeftPanel leftPanel;
	ArrayList<MyShape> shapes = new ArrayList<MyShape>();
	MyLabel draggedShape;
	
	
	public Window() {
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(false);
		setVisible(true);
		WINDOW_INSETS = this.getInsets();
		
		setSize(getWidth() + WINDOW_INSETS.left + WINDOW_INSETS.right, getHeight() + WINDOW_INSETS.top + WINDOW_INSETS.bottom);
		setLocationRelativeTo(null);
		
		
		init();
	}
	
	public void init() {
		
		setLayout(null);
		addMouseListener(this);
		leftPanel = new LeftPanel(this);
		leftPanel.setBounds(0, 0, 160, 600);
		this.add(leftPanel);
		
		windowBoundsX = leftPanel.getWidth() + WINDOW_INSETS.left;
		windowBoundsY = WINDOW_INSETS.top;
		windowBoundsWidth = WINDOW_WIDTH - leftPanel.getWidth();
		windowBoundsHeight = WINDOW_HEIGHT;
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(MyShape shape : shapes)
			shape.draw(g);
	}
	
	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		
		
		
	}
	
	public void addDragShape(MyLabel jLabel) {
		
		try {
			draggedShape = (MyLabel) jLabel.clone();
			this.add(draggedShape);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void removeDragShape(String shape) {
		boolean state;
		if(draggedShape != null) {
			System.out.println(windowBoundsX);
			if(draggedShape.getX() >= leftPanel.getWidth() && draggedShape.getY()  >= 0) {
				switch(shape) {
					case "circle":
						shapes.add(new Circle(draggedShape.getX(), draggedShape.getY(), draggedShape.getWidth(), draggedShape.getHeight()));
						break;
					case "rectangle":
						shapes.add(new Rect(draggedShape.getX(), draggedShape.getY(), draggedShape.getWidth(), draggedShape.getHeight()));
						break;
					case "triangle":
						shapes.add(new Triangle(draggedShape.getX(), draggedShape.getY(), draggedShape.getWidth(), draggedShape.getHeight()));
						break;
					case "plygon":
						shapes.add(new Poly(draggedShape.getX(), draggedShape.getY(), draggedShape.getWidth(), draggedShape.getHeight()));
						break;
				}
			}
			
			this.remove(draggedShape);
			
			
			
		}
		repaint();
	}
	
	public void changeShapeLocation(int newX, int newY) {
		draggedShape.setLocation(newX, newY);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	

	
	
	

}
