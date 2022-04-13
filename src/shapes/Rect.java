package shapes;

import java.awt.Color;

import main.MyShape;

public class Rect extends MyShape{

	public Rect(double x, double y, double width, double height, Color borderColor, Color insiderColor, double mass) {
		super(x, y, width, height, borderColor, insiderColor, mass);
	}

	public Rect(double x, double y, double width, double height, Color borderColor, Color insiderColor) {
		super(x, y, width, height, borderColor, insiderColor);
	}

	public Rect(double x, double y, double width, double height, Color borderColor) {
		super(x, y, width, height, borderColor);
	}

	public Rect(double x, double y, double width, double height, double mass) {
		super(x, y, width, height, mass);
	}

	public Rect(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	
	
}
