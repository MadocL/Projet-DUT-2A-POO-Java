package controller;

import model.Board;

public class Game{
    private Board p;

    public Board getBoard() {
		return p;
	}
    
    public void displayBoard(){
        p.displayBoard();
    }
    
	public void launchNewGame(){
        p = new Board(4, 4);
        p.addNewCell();
        p.addNewCell();
    }

    public void rightMove(){
        p.toTheRight();
        p.mergeToTheRight();
        p.toTheRight();
    }

    public void leftMove() throws Exception{
        p.turn();
        p.turn();
        p.toTheRight();
        p.mergeToTheRight();
        p.toTheRight();
        p.turn();
        p.turn();
    }

    public void upMove() throws Exception{
    	p.turn();
    	p.toTheRight();
    	p.mergeToTheRight();
    	p.toTheRight();
    	p.turn();
    	p.turn();
        p.turn();
    } 

    public void downMove() throws Exception{
    	p.turn();
    	p.turn();
    	p.turn();
    	p.toTheRight();
    	p.mergeToTheRight();
    	p.toTheRight();
    	p.turn();
    } 

    public void oneMove(char keyTyped) throws Exception{
        switch (keyTyped) {
            case 'z':
                upMove();
                break;
            case 'q':
                leftMove();
                break;
            case 's':
                downMove();
                break;
            case 'd':
                rightMove();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + keyTyped);
        }
        p.addNewCell();
    }

    public boolean isOver(){
        return p.isGameOver();
    }
}