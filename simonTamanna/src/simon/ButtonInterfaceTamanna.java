package simon;

import java.awt.Color;

import guiPractice8.component.Action;
import guiPractice8.component.Clickable;

public interface ButtonInterfaceTamanna extends Clickable {

	void setColor(Color color);
	ButtonInterfaceTamanna getAButton();
	void setX(int i);
	void setY(int i);
	void setAction(Action action);
	void dim();
	void highlight();
	boolean isHovered(int x, int y);
	void setName(String string);
	
	
}
