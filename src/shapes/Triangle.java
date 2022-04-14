package shapes;

import java.awt.BasicStroke;
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
		
		int borderThickness = getBorderWidth() == 1 ? 2 : getBorderWidth();
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(borderThickness));
		
		int[] xPoints = new int[] {(int)((this.getX() + this.getWidth()) / 2), (int)(this.getX() + this.getWidth()), (int)this.getX()};
		int[] yPoints = new int[] {(int)(this.getY()), (int)(this.getY() + this.getHeight()), (int)(this.getY() + this.getHeight())};
		
		g2.setColor(getBorderColor());
		g2.drawPolygon(xPoints, yPoints, 3);
		
//		xPoints[1] = (int)(xPoints[1] - borderThickness / 2);
//		xPoints[2] = (int)(xPoints[2] + borderThickness / 2);
//		
//		yPoints[0] = (int)(yPoints[0] + borderThickness / 2);
//		yPoints[1] = (int)(yPoints[1] - borderThickness / 2);
//		yPoints[2] = (int)(yPoints[2] - borderThickness / 2);
		
//		xPoints = new int[] {(int)((getWidth()) / 2 + getX()), (int)(getX() + 1), (int)(getX() + getWidth() - 1)};
//		yPoints = new int[] {(int)(getY() + 1), (int)(getY() + getHeight() - 1), (int)(getY() + getHeight() - 1)};
		
		g2.setColor(getInsiderColor());
		g.fillPolygon(xPoints, yPoints, 3);


	}
	
	
	@Override
	public double getArea() {
		return 0;
	}
	
}
