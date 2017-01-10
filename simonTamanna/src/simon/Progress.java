package simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice8.component.Component;

public class Progress extends Component implements ProgressInterfaceTamanna {

	private static final int WIDTH = 150;
	private static final int HEIGHT = 50;

	private String round;
	private String sequence;
	private boolean gameOver;
	
	// Colors selections for Game Over box
	private int redOver = 160;
	private int greenOver = 35;
	private int blueOver = 54;
	
	// Color selections for during game box
	private int redOn = 2;
	private int greenOn = 252;
	private int blueOn = 194;
	
	public Progress() {
		super(400,300,WIDTH,HEIGHT);
	}

	@Override
	public void gameOver() {
		gameOver = true;
		update();
	}

	@Override
	public void setRound(int r) {
		round = "Round# " + r;
		update();

	}

	@Override
	public void setSequenceSize(int s) {
		sequence = "Longest sequence: "  + s;
		update();

	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(gameOver){
			runOver(g);
		}else{
			runSequence(g);
		}
	}

	private void runSequence(Graphics2D g) {
		FontMetrics fm = g.getFontMetrics();
		g.setColor(new Color(redOn,greenOn,blueOn));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		if(round !=null && sequence != null){

			g.drawString(round, (WIDTH - fm.stringWidth(round))/2, 20);
			g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 40);
		}
		
	}

	private void runOver(Graphics2D g) {
		FontMetrics fm = g.getFontMetrics();
		g.setColor(new Color(redOver,greenOver,blueOver));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.white);
		String gameEnd = "GAME OVER! RESTART!";
		g.drawString(gameEnd, (WIDTH - fm.stringWidth(gameEnd))/2, 20);
		g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 40);
	}
	
	
	
	
}
