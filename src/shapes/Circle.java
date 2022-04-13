package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;

import javax.swing.ImageIcon;

import main.MyShape;

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

		int borderThickness = getBorderWidth() == 1 ? 2 : getBorderWidth();

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(borderThickness));

		g2.setColor(getBorderColor());
		g2.drawOval((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
		g2.setColor(getInsiderColor());
		g2.fillOval((int) getX() + (int) (borderThickness / 2), (int) getY() + (int) (borderThickness / 2),
				(int) getWidth() - (int) (borderThickness), (int) getHeight() - (int) (borderThickness));

	}

	@Override
	public double getArea() {
		return Math.PI * getWidth();
	}

}
