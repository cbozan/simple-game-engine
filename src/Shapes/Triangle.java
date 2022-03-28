package Shapes;

import java.awt.Color;

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
	
}
