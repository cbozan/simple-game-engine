package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Circle extends MyShape {

	
	
	public Circle(double x, double y, double width, double height, Color borderColor, Color insiderColor, double mass) {
		super(x, y, width, height, borderColor, insiderColor, mass);
	}

	public Circle(double x, double y, double width, double height, Color borderColor, Color insiderColor) {
		super(x, y, width, height, borderColor, insiderColor);
	}

	public Circle(double x, double y, double width, double height, Color borderColor) {
		super(x, y, width, height, borderColor);
	}

	public Circle(double x, double y, double width, double height, double mass) {
		super(x, y, width, height, mass);
	}

	public Circle(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	
	@Override
	public void draw(Graphics g) {
		
		g.setColor(getBorderColor());
		g.drawOval((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
		g.setColor(getInsiderColor());
		g.fillOval((int)getX() + 1, (int)getY() + 1, (int)getWidth() - 2, (int)getHeight() - 2);

	}
	
	
	@Override
	public double getArea() {
		return Math.PI * getWidth();
	}
	

}
