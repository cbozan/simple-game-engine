package Shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class MyShape extends Polygon{

	private double x;

	private double y;

	private double width;

	private double height;

	private Color borderColor;

	private Color insiderColor;

	private double mass;

	private double area;

	
	public MyShape(double x, double y, double width, double height) {
		this(x, y, width, height, 1);
	}
	
	
	public MyShape(double x, double y, double width, double height, double mass) {
		this(x, y, width, height, Color.BLACK, Color.WHITE, mass);
		
	}
	

	
	
	public MyShape(double x, double y, double width, double height, Color borderColor) {
		this(x, y, width, height, borderColor, Color.WHITE);
	}

	
	public MyShape(double x, double y, double width, double height, Color borderColor, Color insiderColor) {
		this(x, y, width, height, borderColor, insiderColor, 1);
	}
	

	public MyShape(double x, double y, double width, double height, Color borderColor, Color insiderColor, double mass) {
		super();
		this.x = x;
		this.y = y;
		this.width = this.width < width ? width : this.width;
		this.height = this.height < height ? height : this.height;
		this.borderColor = borderColor;
		this.insiderColor = insiderColor;
		this.mass = mass;
		
		
	}
	

	public void draw(Graphics g) {

		g.setColor(borderColor);
		g.drawRect((int)getX(), (int)getY(), (int)getWidth(), (int)getHeight());
		g.setColor(borderColor);
		g.fillRect((int)getX() + 1, (int)getY() + 1, (int)getWidth() - 2, (int)getHeight() - 2);
	}

	public double getX() {
		return x;
	}

	
	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getInsiderColor() {
		return insiderColor;
	}

	public void setInsiderColor(Color insiderColor) {
		this.insiderColor = insiderColor;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getArea() {
		return (getWidth() * getHeight());
	}



}
