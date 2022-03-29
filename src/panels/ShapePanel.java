package panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MyLabel;

public class ShapePanel extends JPanel {
	
	private MyLabel circle_label, rectangle_label, triangle_label, polygon_label;
	private JLabel shapes_label;
	
	public ShapePanel() {
		
		setBackground(Color.WHITE);
		
		shapes_label = new JLabel("SHAPES") {
			@Override
			public Dimension getPreferredSize() {
				return new Dimension(ShapePanel.this.getWidth(), 50);
			}
		};
		shapes_label.setHorizontalAlignment(JLabel.CENTER);
		
		this.add(shapes_label);
		
		circle_label = new MyLabel(new ImageIcon("src\\icons\\circle.png"));
		circle_label.setName("circle");
		//circle_label.setBounds(13, 50, 124, 124);
		this.add(circle_label);
		
		rectangle_label = new MyLabel(new ImageIcon("src\\icons\\rectangle.png"));
		//rectangle_label.setBounds(13, 50, 124, 124);
		rectangle_label.setName("rectangle");
		this.add(rectangle_label);
		
		triangle_label = new MyLabel(new ImageIcon("src\\icons\\triangle.png"));
		//triangle_label.setBounds(13, 50, 124, 124);
		triangle_label.setName("triangle");
		this.add(triangle_label);
		
		polygon_label = new MyLabel(new ImageIcon("src\\icons\\polygon2.png"));
		//polygon_label.setBounds(13, 50, 124, 124);
		polygon_label.setName("polygon");
		this.add(polygon_label);
		
	}

	public MyLabel getCircle_label() {
		return circle_label;
	}

	public MyLabel getRectangle_label() {
		return rectangle_label;
	}

	public MyLabel getTriangle_label() {
		return triangle_label;
	}

	public MyLabel getPolygon_label() {
		return polygon_label;
	}

	public JLabel getShapes_label() {
		return shapes_label;
	}
	
	
	
}
