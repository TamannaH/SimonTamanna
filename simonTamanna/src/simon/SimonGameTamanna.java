package simon;

import guiPractice8.Screen;
import guiPractice8.GUIApplication;

public class SimonGameTamanna extends GUIApplication {

	public static Screen gameScreen;
	
	public SimonGameTamanna() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		SimonGameTamanna game = new SimonGameTamanna();
		Thread app = new Thread(game);
		app.start();
	}

	protected void initScreen() {
		gameScreen = new SimonScreenTamanna(getWidth(), getHeight());
		setScreen(gameScreen);
	}
}
