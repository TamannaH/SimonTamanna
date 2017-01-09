package simon;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiPractice8.component.Action;
import guiPractice8.component.Component;

public class Button extends Component implements ButtonInterfaceTamanna {

	public Button(int x, int y, int w, int h) {
		super(x, y, w, h);
	
	}

	@Override
	public boolean isHovered(int x, int y) {
		
		return false;
	}

	@Override
	public void act() {
		

	}

	@Override
	public void setColor(Color color) {
		

	}

	@Override
	public ButtonInterfaceTamanna getAButton() {
		
		return null;
	}

	@Override
	public void setAction(Action action) {
		

	}

	@Override
	public void highlight() {
	

	}

	@Override
	public void dim() {
		

	}

	@Override
	public void update(Graphics2D g) {
		

	}

	@Override
	public void setX(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(int i) {
		// TODO Auto-generated method stub
		
	}
}
