package main;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel implements Cloneable{
	
	public MyLabel(ImageIcon imageIcon) {
		super(imageIcon);
		
	}
	
	

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
