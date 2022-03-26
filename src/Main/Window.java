package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Shapes.MyShape;

public class Window extends JFrame implements MouseListener{
	
	LeftPanel leftPanel;
	ArrayList<MyShape> shapes; // will be in main panel 
	MyLabel draggedShape;
	
	public Window() {
		
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(false);
		setVisible(true);
		
		init();
	}
	
	public void init() {
		
		setLayout(null);
		addMouseListener(this);
		leftPanel = new LeftPanel(this);
		this.add(leftPanel);
		
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		//g.drawOval(100, 100, 100, 100);
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
	
	public void removeDragShape(MyLabel jLabel) {
		this.remove(draggedShape);
		repaint();
	}
	
	public void changeShapeLocation(int newX, int newY) {
		draggedShape.setLocation(newX, newY);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("pressed");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	

	
	
	

}
