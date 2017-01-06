package simon;

import guiPackage.guiApplication;

public class SimonGameTamanna extends guiApplication {

	public static SimonScreenTamanna gameScreen;
	
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
