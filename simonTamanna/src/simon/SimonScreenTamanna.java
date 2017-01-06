package simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPackage.components.Action;
import guiPackage.components.Button;
import guiPackage.components.TextLabel;
import guiPackage.components.Visible;
import guiPackage.sampleGames.ClickableScreen;

public class SimonScreenTamanna extends ClickableScreen implements Runnable {
	//public ArrayList<ButtonInterfaceTamanna> button;
	private ButtonInterfaceTamanna[] button;
	public ArrayList<MoveInterfaceTamanna> moveList;
	public ArrayList<MoveInterfaceTamanna> sequenceOfMoves;
	public ProgressInterfaceTamanna progress;
	public TextLabel label;
	public int roundNumber;
	public int sequenceIndex;
	public static boolean acceptingInput;	
	
	private int lastSelectedButton;
	
	public SimonScreenTamanna(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void run() {
		label.setText("");
		nextRound();
	}

	public void nextRound() {
		acceptingInput =false;
		roundNumber ++;
		sequenceOfMoves.add(randomMove());
		//check
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequenceOfMoves.size());
		
		changeText("Simon's Turn");
		label.setText("");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceTamanna b = null;
		for(int i = 0; i < sequenceOfMoves.size(); i++){
			if(b != null) b.dim();
			
			b = sequenceOfMoves.get(sequenceIndex).getButton();
			b.highlight();
		
			//10 seconds time
			int sleepTime = 10000/roundNumber;
			if(sleepTime<=0)sleepTime=2;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		b.dim();
	}

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequenceOfMoves = new ArrayList<MoveInterfaceTamanna>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequenceOfMoves.add(randomMove());
		sequenceOfMoves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	public MoveInterfaceTamanna randomMove() {
		ButtonInterfaceTamanna b = null;
		int randNum = (int)(Math.random()*button.length);
		
		while(randNum == lastSelectedButton){
			randNum = (int)(Math.random()*button.length);
		}
		
		b = button[randNum];
		lastSelectedButton = randNum;
		return getMove(b);
	}

	public MoveInterfaceTamanna getMove(ButtonInterfaceTamanna b) {
		return null;
	}

	public ProgressInterfaceTamanna getProgress() {
		//Partner's code
		return null;
	}

	public void addButtons(ArrayList<Visible> viewObjects) {
		int numOfButtons = 4;
		Color[] colors= {Color.blue,Color.red, Color.yellow, Color.green};
		
		for(int i= 0; i < numOfButtons; i++){
			
			final ButtonInterfaceTamanna b = getAButton();
			b.setColor(colors[i]);
			b.setX(50);
			b.setY(50);
			
			b.setAction(new Action(){
				public void act() {
					if(acceptingInput){
						Thread blink = new Thread(new Runnable(){
							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
									b.dim();
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						});
						blink.start();
					}
				}
				
			});
			
			if (b == sequenceOfMoves.get(sequenceIndex)){
				sequenceIndex++;
			}
			else{
				progress.gameOver();
			}
			if (sequenceIndex == sequenceOfMoves.size()){
				Thread nextRound = new Thread(SimonScreenTamanna.this);
				nextRound.start();
			}
			viewObjects.add(b);
		}
		
	}

	private ButtonInterfaceTamanna getAButton() {
		return null;
	}
}
	

