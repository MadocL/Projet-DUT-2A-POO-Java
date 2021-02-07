package view;

import controller.Game;

import java.util.concurrent.TimeUnit;

public class Launcher {
    private final Game g;
    private int score;
    private Application application;
    
    Launcher(){
    	g = new Game();
    	score = 0;
    }
    
    public void play() throws Exception{
        application = new Application(); //launch the JFrame
        application.setVisible(true);
        g.launchNewGame(); //start the game
        application.setBoard(g.getBoard()); //refresh the view with the new board
        
        g.displayBoard();
        while(!g.isOver()) {
        	if(application.getKeyTyped() != '\0'){
        	    g.oneMove(application.getKeyTyped());
        	    application.setKeyTyped('\0');
            }
            g.displayBoard();
        	application.setBoard(g.getBoard());
        	application.getUIBoard().updateUI();
        	System.out.println("-------------");
            TimeUnit.MILLISECONDS.sleep(33); //wait 33 milliseconds to have 30 FPS
        }

        //determine the score
        for (int i = 0; i < g.getBoard().getBoard().length; i++) {
			for (int j = 0; j < g.getBoard().getBoard()[i].length ; j++) {
				if (score < g.getBoard().getBoard()[i][j].getValue()) {
					score = g.getBoard().getBoard()[i][j].getValue();
				}
			}
        }
        System.out.println("Game over ! Your score is: " + score);
    }

	public static void main(String [] args) throws Exception {
		new Launcher().play();
	}
}