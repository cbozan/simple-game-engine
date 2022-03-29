package shapes;

import java.awt.Color;

import main.MyShape;

public class Poly extends MyShape{

	public Poly(double x, double y, double width, double height, Color borderColor, Color insiderColor, double mass) {
		super(x, y, width, height, borderColor, insiderColor, mass);
	}

	public Poly(double x, double y, double width, double height, Color borderColor, Color insiderColor) {
		super(x, y, width, height, borderColor, insiderColor);
	}

	public Poly(double x, double y, double width, double height, Color borderColor) {
		super(x, y, width, height, borderColor);
	}

	public Poly(double x, double y, double width, double height, double mass) {
		super(x, y, width, height, mass);
	}

	public Poly(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
}
