package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import shapes.Circle;

public class LeftPanel extends JPanel implements MouseListener, MouseMotionListener{
	
	JLabel shapes_label;
	MyLabel circle_label, rectangle_label, triangle_label, polygon_label;
	MyLabel currentDraggedShape;
	Window superWindow;
	int rX, rY;
	
	public LeftPanel(Window superWindow) {
		
		
		setBackground(Color.white);
		
		this.superWindow = superWindow;
		
		shapes_label = new JLabel("SHAPES") {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(160, 80);
			}
		};
		shapes_label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(shapes_label);
		
		circle_label = new MyLabel(new ImageIcon("src\\icons\\circle.png"));
		circle_label.setName("circle");
		circle_label.setBounds(13, 50, 124, 124);
		circle_label.addMouseListener(this);
		circle_label.addMouseMotionListener(this);
		this.add(circle_label);
		
		rectangle_label = new MyLabel(new ImageIcon("src\\icons\\rectangle.png"));
		rectangle_label.setBounds(13, 50, 124, 124);
		rectangle_label.setName("rectangle");
		rectangle_label.addMouseListener(this);
		rectangle_label.addMouseMotionListener(this);
		this.add(rectangle_label);
		
		triangle_label = new MyLabel(new ImageIcon("src\\icons\\triangle.png"));
		triangle_label.setBounds(13, 50, 124, 124);
		triangle_label.setName("triangle");
		triangle_label.addMouseListener(this);
		triangle_label.addMouseMotionListener(this);
		this.add(triangle_label);
		
		polygon_label = new MyLabel(new ImageIcon("src\\icons\\polygon2.png"));
		polygon_label.setBounds(13, 50, 124, 124);
		polygon_label.setName("polygon");
		polygon_label.addMouseListener(this);
		polygon_label.addMouseMotionListener(this);
		this.add(polygon_label);
		
		
	}

	
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		rX = e.getX();
		rY = e.getY();
		
		superWindow.addDragShape(((MyLabel)e.getSource()));
		try {
			currentDraggedShape = (MyLabel) ((MyLabel)e.getSource()).clone();
			this.add(currentDraggedShape);
		} catch (CloneNotSupportedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		superWindow.removeDragShape(((MyLabel)e.getSource()).getName());
		this.remove(currentDraggedShape);

		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
//		if(e.getSource() == circle_label) {
//			System.out.println("circle_labelmouseClicked");
//		} else if(e.getSource() == rectangle_label) {
//			System.out.println("rectangle_labelmouseClicked");
//		} else if(e.getSource() == triangle_label) {
//			System.out.println("triangle_labelmouseClicked");
//		} else if(e.getSource() == polygon_label) {
//			System.out.println("polygon_labelmouseClicked");
//		}
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		
		int newX = ((JLabel)e.getSource()).getX() - (rX - e.getX());
		int newY = ((JLabel)e.getSource()).getY() - (rY - e.getY());
		
		superWindow.changeShapeLocation(newX, newY);
		currentDraggedShape.setLocation(newX, newY);
		
//		if(e.getSource() == circle_label) {
//			
//			System.out.println(rX + ", " + rY);
//			
//			
//			((JLabel)e.getSource()).setLocation(newX, newY);
//			
//			
//			System.out.println("circle_labelmouseDragged");
//		} else if(e.getSource() == rectangle_label) {
//			System.out.println("rectangle_labelmouseDragged");
//		} else if(e.getSource() == triangle_label) {
//			System.out.println("triangle_labelmouseDragged");
//		} else if(e.getSource() == polygon_label) {
//			System.out.println("polygon_labelmouseDragged");
//		}
//		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
//		if(e.getSource() == circle_label) {
//			System.out.println("circle_labelmouseMoved");
//		} else if(e.getSource() == rectangle_label) {
//			System.out.println("rectangle_labelmouseMoved");
//		} else if(e.getSource() == triangle_label) {
//			System.out.println("triangle_labelmouseMoved");
//		} else if(e.getSource() == polygon_label) {
//			System.out.println("polygon_labelmouseMoved");
//		}
		
	}
	

}
