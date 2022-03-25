package Main;

import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame implements MouseListener{
	
	LeftPanel leftPanel;
	
	
	public Window() {
		
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setUndecorated(false);
		setVisible(true);
		
		init();
	}
	
	public void init() {
		
		setLayout(null);
		addMouseListener(this);
		leftPanel = new LeftPanel();
		this.add(leftPanel);
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if(leftPanel.getIntersectShape(e.getX(), e.getY(), 50, 50) != null){
			System.out.println("Intersect");
		} else {
			System.out.println("null");
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	

}
