package shapes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import main.MyShape;

public class Triangle extends MyShape{
	
	public Triangle(double x, double y, double width, double height, Color borderColor, Color insiderColor, double mass) {
		super(x, y, width, height, borderColor, insiderColor, mass);
	}

	public Triangle(double x, double y, double width, double height, Color borderColor, Color insiderColor) {
		super(x, y, width, height, borderColor, insiderColor);
	}

	public Triangle(double x, double y, double width, double height, Color borderColor) {
		super(x, y, width, height, borderColor);
	}

	public Triangle(double x, double y, double width, double height, double mass) {
		super(x, y, width, height, mass);
	}

	public Triangle(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	
	@Override
	public void draw(Graphics g) {
		
		int[] xPoints = new int[] {(int)(getWidth() / 2 + getX()), (int)(getX()), (int)(getX() + getWidth())};
		int[] yPoints = new int[] {(int)(getY()), (int)(getY() + getHeight()), (int)(getY() + getHeight())};
		
		g.setColor(getBorderColor());
		g.drawPolygon(xPoints, yPoints, 3);
		
		xPoints = new int[] {(int)((getWidth() - 2) / 2 + getX() + 1), (int)(getX() + 1), (int)(getX() + getWidth() - 1)};
		yPoints = new int[] {(int)(getY() + 1), (int)(getY() + getHeight() - 2), (int)(getY() + getHeight() - 2)};
		g.setColor(getInsiderColor());
		g.fillPolygon(xPoints, yPoints, 3);

	}
	
	
	@Override
	public double getArea() {
		return 0;
	}
	
}
