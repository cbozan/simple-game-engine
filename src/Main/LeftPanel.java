package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import Shapes.Circle;
import Shapes.MyShape;

public class LeftPanel extends JPanel{
	ArrayList<MyShape> shapes;
	
	public LeftPanel() {
		
		setSize(150, 600);
		setBackground(Color.red);
		
		shapes = new ArrayList<MyShape>();
		shapes.add(new Circle(25, 250, 100, 100, Color.RED, Color.WHITE));
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		for(MyShape shape : shapes) {
			shape.draw(g);
		}
		
	}
	
	
	
	public MyShape getIntersectShape(double x, double y, double width, double height) {
		
		for(MyShape s : shapes) {
			if(s.intersects(x, y, width, height)) {
				return s;
			} else {
				System.out.print("s.getX() = " + s.getX() + ", s.getY() = " + s.getY() + "x = " + x + ", y = " + y);
			}
		}
		
		return null;
	}
}
