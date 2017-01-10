package simon;

import java.awt.Color;

import guiPractice8.component.Action;
import guiPractice8.component.Clickable;

public interface ButtonInterfaceTamanna extends Clickable {
	
	void setColor(Color color);

	void highlight();

	void dim();

	void setAction(Action action);

	void setX(int i);

	void setY(int i);
}
