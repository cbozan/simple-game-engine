package panels;

import main.MyShape;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import main.Window;

public class FeaturesPanel extends JPanel implements CaretListener{

	private ArrayList<MyShape> shapes;
	private int currentShape;
	private boolean state = false;
	
	private JTextField x_textField, y_textField, width_textField, height_textField, borderColor_textField;
	private JTextField borderWidth_textField, insiderColor_textField, mass_textField, gravity_textField, bounce_textField;
	
	private JLabel x_label, y_label, width_label, height_label, borderColor_label;
	private JLabel borderWidth_label, insiderColor_label, mass_label, gravity_label, bounce_label;
	
	public FeaturesPanel(ArrayList<MyShape> shapes) {
		setBackground(Color.white);
		this.shapes = shapes;
		addUtils();
	}
	
	public void addUtils() {
		
		
		x_label = new JLabel("X Position") {@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight());}};
		x_label.setHorizontalAlignment(JLabel.CENTER);
		this.add(x_label);
		
		x_textField = new JTextField(String.valueOf((int)getCurrentShape().getX()), 10);
		x_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(x_textField);
		
		y_label = new JLabel("Y Position") {@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight() + 3);}};
		y_label.setHorizontalAlignment(JLabel.CENTER);
		y_label.setVerticalAlignment(JLabel.BOTTOM);
		this.add(y_label);
		
		y_textField = new JTextField(String.valueOf((int)getCurrentShape().getY()), 10);
		y_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(y_textField);
		
		width_label = new JLabel("Shape Width"){@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight() + 3);}};
		width_label.setHorizontalAlignment(JLabel.CENTER);
		width_label.setVerticalAlignment(JLabel.BOTTOM);
		this.add(width_label);
		
		width_textField = new JTextField(String.valueOf((int)getCurrentShape().getWidth()), 10);
		width_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(width_textField);
		
		height_label = new JLabel("Shape Height"){@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight() + 3);}};
		height_label.setHorizontalAlignment(JLabel.CENTER);
		height_label.setVerticalAlignment(JLabel.BOTTOM);
		this.add(height_label);
		
		height_textField = new JTextField(String.valueOf((int)getCurrentShape().getHeight()), 10);
		height_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(height_textField);
		
		
		
		borderWidth_label = new JLabel("Border Width"){@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight() + 3);}};
		borderWidth_label.setHorizontalAlignment(JLabel.CENTER);
		borderWidth_label.setVerticalAlignment(JLabel.BOTTOM);
		this.add(borderWidth_label);
		
		borderWidth_textField = new JTextField(String.valueOf((int)getCurrentShape().getBorderWidth()), 10);
		borderWidth_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(borderWidth_textField);
		
		insiderColor_label = new JLabel("Insider Color (yellow)"){@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight() + 3);}};
		insiderColor_label.setHorizontalAlignment(JLabel.CENTER);
		insiderColor_label.setVerticalAlignment(JLabel.BOTTOM);
		this.add(insiderColor_label);
		
		insiderColor_textField = new JTextField("", 10);
		insiderColor_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(insiderColor_textField);
		
		borderColor_label = new JLabel("Border Color (black)"){@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight() + 3);}};
		borderColor_label.setHorizontalAlignment(JLabel.CENTER);
		borderColor_label.setVerticalAlignment(JLabel.BOTTOM);
		this.add(borderColor_label);
		
		borderColor_textField = new JTextField("", 10);
		borderColor_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(borderColor_textField);
		
		mass_label = new JLabel("Mass"){@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight() + 3);}};
		mass_label.setHorizontalAlignment(JLabel.CENTER);
		mass_label.setVerticalAlignment(JLabel.BOTTOM);
		this.add(mass_label);
		
		mass_textField = new JTextField(String.valueOf((int)getCurrentShape().getMass()), 10);
		mass_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(mass_textField);
		
		gravity_label = new JLabel("Gravity ( % )"){@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight() + 3);}};
		gravity_label.setHorizontalAlignment(JLabel.CENTER);
		gravity_label.setVerticalAlignment(JLabel.BOTTOM);
		this.add(gravity_label);
		
		gravity_textField = new JTextField(String.valueOf((int)getCurrentShape().getGravity()), 10);
		gravity_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(gravity_textField);
		
		bounce_label = new JLabel("Bounce ( % )"){@Override public Dimension getPreferredSize() {return new Dimension(FeaturesPanel.this.getWidth(), (int)super.getPreferredSize().getHeight() + 3);}};
		bounce_label.setHorizontalAlignment(JLabel.CENTER);
		bounce_label.setVerticalAlignment(JLabel.BOTTOM);
		this.add(bounce_label);
		
		bounce_textField = new JTextField("", 10);
		bounce_textField.setHorizontalAlignment(JLabel.CENTER);
		this.add(bounce_textField);
		
		x_textField.addCaretListener(this);
		gravity_textField.addCaretListener(this);
		mass_textField.addCaretListener(this);
		borderColor_textField.addCaretListener(this);
		insiderColor_textField.addCaretListener(this);
		borderWidth_textField.addCaretListener(this);
		height_textField.addCaretListener(this);
		width_textField.addCaretListener(this);
		y_textField.addCaretListener(this);
		bounce_textField.addCaretListener(this);
		
		
	
	}
	
	public void loadProperties() {
		x_textField.setText(getCurrentShape().getX() + "");
		y_textField.setText(getCurrentShape().getY() + "");
		width_textField.setText(getCurrentShape().getWidth() + "");
		height_textField.setText(getCurrentShape().getHeight() + "");
		borderWidth_textField.setText(getCurrentShape().getBorderWidth() + "");
		insiderColor_textField.setText("");
		borderColor_textField.setText("");
		mass_textField.setText(String.valueOf(getCurrentShape().getMass()));
		gravity_textField.setText(String.valueOf(getCurrentShape().getGravity()));
		bounce_textField.setText(String.valueOf(getCurrentShape().getBounce()));
	
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}


	public MyShape getCurrentShape() {
		if(getShapes().size() <= currentShape)
			return new MyShape(0, 0, 0, 0);
		return getShapes().get(currentShape);
	}

	public ArrayList<MyShape> getShapes() {
		return shapes;
	}
	
	public void setCurrentShape(int i) {
		this.currentShape = i;
		this.loadProperties();
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		
		if(((JTextField)e.getSource()).equals(x_textField)) {
			
			try {
				getCurrentShape().setX(Integer.parseInt(x_textField.getText()));
				state = true;
			} catch(NumberFormatException nfe) {
				
			}
			
			
		} else if(((JTextField)e.getSource()).equals(y_textField)) {
			
			try {
				getCurrentShape().setY(Integer.parseInt(y_textField.getText()));
				state = true;
			} catch(NumberFormatException nfe) {
				
			}
			
		} else if(((JTextField)e.getSource()).equals(width_textField)) {
			
			try {
				getCurrentShape().setWidth(Integer.parseInt(width_textField.getText()));
				state = true;
			} catch(NumberFormatException nfe) {
				
			}
		
		} else if(((JTextField)e.getSource()).equals(height_textField)) {
			
			try {
				getCurrentShape().setHeight(Integer.parseInt(height_textField.getText()));
				state = true;
			} catch(NumberFormatException nfe) {
				
			}
			
		} else if(((JTextField)e.getSource()).equals(borderWidth_textField)) {
			
			try {
				getCurrentShape().setBorderWidth(Integer.parseInt(borderWidth_textField.getText()));
				state = true;
			} catch(NumberFormatException nfe) {
				
			}
			
		} else if(((JTextField)e.getSource()).equals(insiderColor_textField)) {
			Color color;
			try {
				color = (Color)Class.forName("java.awt.Color").getField(insiderColor_textField.getText()).get(null);
			} catch(Exception exception) {
				color = null;
			}
			
			if(color != null) {
				getCurrentShape().setInsiderColor(color);
				state = true;
			}
		} else if(((JTextField)e.getSource()).equals(borderColor_textField)) {
			
			Color color;
			try {
				color = (Color)Class.forName("java.awt.Color").getField(borderColor_textField.getText()).get(null);
			} catch(Exception exception) {
				color = null;
			}
			
			if(color != null) {
				getCurrentShape().setBorderColor(color);
				state = true;
			}
		} else if(((JTextField)e.getSource()).equals(mass_textField)) {
			try {
				getCurrentShape().setMass(Double.parseDouble(mass_textField.getText()));
				state = true;
			} catch(NumberFormatException nfe) {
				
			}
		} else if(((JTextField)e.getSource()).equals(gravity_textField)) {
			try {
				getCurrentShape().setGravity(Double.parseDouble(gravity_textField.getText()));
				state = true;
			} catch(NumberFormatException nfe) {
				
			}
		} else if(((JTextField)e.getSource()).equals(bounce_textField)) {
			
			try {
				getCurrentShape().setBounce(Integer.parseInt(bounce_textField.getText()));
				state = true;
			} catch(NumberFormatException nfe) {
				
			}
			
		}
		
		if(state) {
			this.getParent().revalidate();
			this.getParent().repaint();
			this.revalidate();
			this.repaint();
			state = false;
			//loadProperties();
		}
		
		
	}
	
	
}
