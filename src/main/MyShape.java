package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyShape extends Rectangle {

	private static final long serialVersionUID = 1L;
	private double x;
	private double y;
	private double width;
	private double height;
	private Color borderColor;
	private int borderWidth;
	private Color insiderColor;
	private double mass;
	private double area;
	private double gravity;
	private boolean selected;
	private double bounce;
	private double v = 0;
	private double energy;

	public MyShape(double x, double y, double width, double height) {
		this(x, y, width, height, 1);
	}

	public MyShape(double x, double y, double width, double height, double mass) {
		this(x, y, width, height, Color.WHITE, Color.WHITE, mass);

	}

	public MyShape(double x, double y, double width, double height, Color borderColor) {
		this(x, y, width, height, borderColor, Color.WHITE);
	}

	public MyShape(double x, double y, double width, double height, Color borderColor, Color insiderColor) {
		this(x, y, width, height, borderColor, insiderColor, 1);
	}

	public MyShape(double x, double y, double width, double height, Color borderColor, Color insiderColor,
			double mass) {
		super();
		this.x = x;
		this.y = y;
		this.width = this.width < width ? width : this.width;
		this.height = this.height < height ? height : this.height;
		this.borderColor = borderColor;
		this.insiderColor = insiderColor;
		this.mass = mass;
		this.selected = false;
		this.borderWidth = 2;
		this.gravity = 0;
		this.bounce = 50;
		this.energy = (Window.WINDOW_HEIGHT - this.y - this.height);
	}

	public void g(double x) {
		
		v += (this.getGravity() / x);
		
		if(v < 0) {
			this.setY(this.getY() + (v / x));
		} else {
			if((this.getY() + this.getHeight() + (v / x) < Window.WINDOW_HEIGHT) )
				this.setY(this.getY() + (v / x));
			else {
				this.setY(Window.WINDOW_HEIGHT - this.getHeight());
				energy = (bounce * (energy / 100));
				v = 0 - ((this.getGravity()) * Math.sqrt((2 * energy) / (this.getGravity())));
			}
		} 
	}

	public void draw(Graphics g) {

		int borderThickness = getBorderWidth() == 1 ? 2 : getBorderWidth();

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(borderThickness));

		g2.setColor(getBorderColor());
		g2.drawRect((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
		g2.setColor(getInsiderColor());
		g2.fillRect((int) getX() + (int) (borderThickness / 2), (int) getY() + (int) (borderThickness / 2),
				(int) getWidth() - (int) (borderThickness), (int) getHeight() - (int) (borderThickness));

	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		if (w <= 0 || h <= 0)
			return false;
		double x0 = getX();
		double y0 = getY();
		return (x + w > x0 && y + h > y0 && x < x0 + getWidth() && y < y0 + getHeight());
	}

	public int getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
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

	public boolean getSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Color getBorderColor() {
		if (getSelected())
			return Color.green;
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

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getBounce() {
		return bounce;
	}

	public void setBounce(int bounce) {
		this.bounce = bounce;
	}

	
}
