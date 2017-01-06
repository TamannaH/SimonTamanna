package simon;

public class Move implements MoveInterfaceTamanna {

	private ButtonInterfaceTamanna button;
	
	public Move(ButtonInterfaceTamanna button) {
		this.button = button;
	}
	
	public ButtonInterfaceTamanna getButton() {
		return button;
	}
}
