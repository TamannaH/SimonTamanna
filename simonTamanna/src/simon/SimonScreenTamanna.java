package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiPractice8.component.ClickableScreen;
import guiPractice8.component.TextArea;
import guiPractice8.component.Action;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;

public class SimonScreenTamanna extends ClickableScreen implements Runnable {

	private TextLabel label;
	private ButtonInterfaceTamanna[] button;
	private ProgressInterfaceTamanna progress;
	private ArrayList<MoveInterfaceTamanna> sequence;
	
	//Intro words for when a user opens up the game
		private TextLabel introWords;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenTamanna(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("");
		nextRound();
	}

	public void nextRound() {
		acceptingInput =false;
		roundNumber ++;
		sequence.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(sequence.size());
		
		changeText("Simon's Turn");
		label.setText("");
		playSequence();
		changeText("Your Turn");
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceTamanna b = null;
		for(int i=0;i<sequence.size();i++){
			if(b!=null)b.dim();
			b = sequence.get(i).getButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		b.dim();
	}

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(200);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public MoveInterfaceTamanna randomMove() {
		ButtonInterfaceTamanna b = null;
		int randNum = (int)(Math.random()*button.length);
		while(randNum==lastSelectedButton){
			randNum = (int)(Math.random()*button.length);
		}
		b = button[randNum];
		lastSelectedButton = randNum;
		return new Move(b);
	}


	public ProgressInterfaceTamanna getProgress() {
		return new Progress();
	}

	public void addButtons(List<Visible> viewObjects) {
		int numOfButtons = 6;
		button = new ButtonInterfaceTamanna[numOfButtons];
		Color[] colors= {Color.blue,Color.red,Color.magenta, Color.cyan, 
				Color.green, Color.pink};
		for(int i= 0; i<numOfButtons; i++){
			button[i] = getAButton();
			button[i].setColor(colors[i]);
			button[i].setX(250 + (int)(80*Math.cos(i*2*Math.PI/(numOfButtons))));
			button[i].setY(175 - (int)(80*Math.sin(i*2*Math.PI/(numOfButtons))));
			final ButtonInterfaceTamanna b = button[i];
			b.dim();
			b.setAction(new Action(){
				public void act() {
					Thread blink = new Thread(new Runnable(){
						public void run() {
							b.highlight();
							try {
								Thread.sleep(400);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							b.dim();
						}
							
					});
					blink.start();
					if(acceptingInput && sequence.get(sequenceIndex).getButton() == b){
						sequenceIndex++;
					}else if(acceptingInput){
						progress.gameOver();
						return;
					}
					if(sequenceIndex == sequence.size()){
						Thread nextRound = new Thread(SimonScreenTamanna.this);
						nextRound.start();
					}
				}
				
			});
			viewObjects.add(button[i]);
		}
		
	}

	private ButtonInterfaceTamanna getAButton() {
		return new Button();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		sequence = new ArrayList<MoveInterfaceTamanna>();
		addButtons(viewObjects);
		progress = getProgress();
//		introWords = new TextLabel(0,0,0,0,"Welcome to Simon!"
//				+ " A memory game that will test your greatest potential. All one has to do is select the colors that are chosen in a specific order. "
//				+ "The number of colors selected increase each round and get faster.");
		label = new TextLabel(220,310,300,40,"Let's play Simon!");
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
	}

}