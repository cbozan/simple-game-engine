package panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;

import main.MainPanel;
import main.MyShape;

public class ScenePanel extends JPanel implements MouseListener{
	
	private int x;
	private int y;
	private int width;
	private int height;
	private ArrayList<MyShape> shapes;
	private int currentShape;
	Long waitTime;
	
	public ScenePanel(int x, int y, int width, int height, ArrayList<MyShape> shapes) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shapes = shapes;
		
		this.setBackground(new Color(210, 210, 210));
		this.setBounds(x, y, width, height);
		
		this.addMouseListener(this);
		
		init();

	}
	
	
	public void init() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				Long firstTime, lastTime, waitTime;
				int fps = MainPanel.FPS;
				int i = fps;
				
				while(i-- > 0) {
					
					firstTime = System.currentTimeMillis();
					for(MyShape shape : getShapes()) {
						shape.g(fps);
					}
					
					lastTime = System.currentTimeMillis();
					
					try {
						waitTime = ((1000 / fps) - (lastTime - firstTime));
						Thread.sleep(waitTime < 0L ? 0L : waitTime);
					} catch (InterruptedException e) {}
					
					if(fps != MainPanel.FPS)
						break;
				}
				
				this.run();
				
			}
		}).start();
		
	}
	
	
	public void paint(Graphics g) {
		super.paint(g);
		for(MyShape shape : getShapes()) {
			shape.draw(g);
		}
		
		
		
		getParent().revalidate();
		getParent().repaint();
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
	}
	
	
	
	public int getCurrentShape() {
		if(getShapes().size() < currentShape) {
			System.out.println("Index out of bounds getCurrentShape Method");
			return getShapes().size();
		}
		return currentShape;
	}

	public void setCurrentShape(int currentShape) {
		this.currentShape = currentShape;
		
	}

	
	
	public ArrayList<MyShape> getShapes() {
		if(shapes == null)
			shapes = new ArrayList<>();
		return shapes;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(shapes.size() > getCurrentShape()) {
			shapes.get(getCurrentShape()).setSelected(false);
		}
		
		for(int i = 0; i < shapes.size(); i++) {
			if(getShapes().get(i).intersects(e.getX(), e.getY(), 1, 1)) {
				getShapes().get(i).setSelected(true);
				this.setCurrentShape(i);
				//FeaturesPanel.setCurrentShape(getCurrentShape()); 
				((MainPanel)getParent()).getFeaturesPanel().setCurrentShape(getCurrentShape());
				getParent().revalidate();
				getParent().repaint();
				
				break;
			}
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
