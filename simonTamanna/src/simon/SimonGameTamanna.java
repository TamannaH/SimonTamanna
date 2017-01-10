package simon; 

import guiPractice8.GUIApplication;

public class SimonGameTamanna extends GUIApplication {

	private static final long serialVersionUID = 4297926260023939521L;

	public SimonGameTamanna() {
		super();
	}

	@Override
	public void initScreen() {
		SimonScreenTamanna click = new SimonScreenTamanna(getWidth(),getHeight());
		setScreen(click);

	}

	public static void main(String[] args) {
		SimonGameTamanna game = new SimonGameTamanna();
		Thread app = new Thread(game);
		app.start();
	}

}
