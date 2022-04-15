package panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.MainPanel;
import main.MyShape;

public class ScenePanel extends JPanel implements MouseListener{
	
	private int x;
	private int y;
	private int width;
	private int height;
	private ArrayList<MyShape> shapes;
	private int currentShape;
	
	public ScenePanel(int x, int y, int width, int height, ArrayList<MyShape> shapes) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.shapes = shapes;
		
		this.setBackground(Color.orange);
		this.setBounds(x, y, width, height);
		
		this.addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(MyShape shape : getShapes())
			shape.draw(g);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
	}
	
	
	
	public int getCurrentShape() {
		if(getShapes().size() <= currentShape) {
			System.out.println("Index out of bounds getCurrentShape Method");
			return getShapes().size() - 1;
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
		System.out.println("" + e.getX() + ", " + e.getY() );
		if(shapes.size() > getCurrentShape()) {
			shapes.get(getCurrentShape()).setSelected(false);
		}
		
		for(int i = 0; i < shapes.size(); i++) {
			if(getShapes().get(i).intersects(e.getX(), e.getY(), 1, 1)) {
				System.out.println("intesects");
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
