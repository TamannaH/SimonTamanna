package simon;

import java.awt.Color;

import guiPackage.components.Action;
import guiPackage.components.Clickable;

public interface ButtonInterfaceTamanna extends Clickable {

	void setColor(Color color);
	ButtonInterfaceTamanna getAButton();
	void setX(int i);
	void setY(int i);
	void setAction(Action action);
	void dim();
	void highlight();
	
	
}
