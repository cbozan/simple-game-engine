package panels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.DimensionUIResource;

import main.MainPanel;
import main.MyLabel;

public class ShapePanel extends JPanel {
	
	private MyLabel circle_label, rectangle_label, triangle_label, polygon_label;
	private JLabel shapes_label, fps_label;
	private JSlider fps_slider;
	private String fps_text = "FPS : ";
	
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
		
		JPanel sliderPanel = new JPanel();
		sliderPanel.setLayout(null);
		sliderPanel.setPreferredSize(new Dimension(150, 200));
		sliderPanel.setBackground(getBackground());
		this.add(sliderPanel);
		
		fps_label = new JLabel(fps_text + "24");
		fps_label.setBounds(0, 20, 150, 70);
		fps_label.setHorizontalAlignment(SwingConstants.CENTER);
		fps_label.setVerticalAlignment(SwingConstants.CENTER);
		sliderPanel.add(fps_label);
		
		fps_slider = new JSlider();
		fps_slider.setValue(25);
		fps_slider.setBackground(this.getBackground());
		fps_slider.setPaintLabels(true);
		fps_slider.setPaintTicks(true);
		fps_slider.setPaintTrack(true);
		fps_slider.setMaximum(80);
		fps_slider.setMinimum(5);
		fps_slider.setMinorTickSpacing(10);
		fps_slider.setMajorTickSpacing(20);
		fps_slider.setBounds(10, 70, 130, 60);
		fps_slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				fps_label.setText(fps_text + fps_slider.getValue());
				MainPanel.FPS = fps_slider.getValue();
			}
		});
		sliderPanel.add(fps_slider);
		
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
