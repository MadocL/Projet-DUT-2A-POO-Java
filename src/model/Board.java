package model;

import java.util.ArrayList;

public class Board {
    private final int height;
    private final int width;
    private Cell[][] board;

    public Cell[][] getBoard() {
		return board;
	}

	public Board(int h, int w){
        height = h;
        width = w;
        board = new Cell[height][width];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = new Cell(0);
            }
        }
    }

    //extra constructor
    public Board(int[][] tabInt){
    	board = new Cell[tabInt.length][tabInt[0].length];
        for(int i = 0; i < tabInt.length; i++){
            for(int j = 0; j < tabInt[i].length; j++){
                board[i][j] = new Cell(tabInt[i][j]);
            }
        }
        height = board.length;
        width = board[0].length;
    }

    public void displayBoard() {
    	for (Cell [] line : board) {
    		for(Cell c : line) {
    			System.out.print(c + "\t");
    		}
    		System.out.print("\n");
    	}
    }

    public ArrayList<Integer []> getEmptyCells(){
        ArrayList<Integer[]> emptyCells = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
               if (board[i][j].getValue() == 0) {
            	   Integer[] vide = {i, j};
                   emptyCells.add(vide);
               }
            }
        }
        return emptyCells;
    }
    
    public void addNewCell() {
    	ArrayList<Integer[]> emptyCells = this.getEmptyCells();
        if (!emptyCells.isEmpty()){
        	int cell = (int) (Math.random() * emptyCells.size());
        	int random = (int) (Math.random() * 5);
            Integer[] coordinates = emptyCells.get(cell);

            if (random  == 4) board[coordinates[0]][coordinates[1]].setValue(4);
            else board[coordinates[0]][coordinates[1]].setValue(2);
        }
    }

    public void turn() throws Exception{ //90 degrees turn of the matrix
        if (height == width){
            int max = height;
            int k = 0;
            Cell[][] turnedBoard = new Cell[max][max];
            
            for (int i = 0; i < max; i++){
                for (int j = 0; j < max; j++){
                    turnedBoard[k][max - 1 - i] = board[i][j];
                    k++;
                }
                k = 0;
            }
            board = turnedBoard;
        }
        else{
            throw new Exception("turn error : non-square matrix");
        }
    }

    public void toTheRight() {
        Cell temp;
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[i].length; j++) {
        	    if (board[i][j].getValue() == 0) {
        	        //for each cells before the "0", set more to the left this 0 by switching values
        			for(int k = j; k > 0; k--){
        			    temp = board[i][k];
        			    board[i][k] = board[i][k - 1];
        			    board[i][k - 1] = temp;
        			}
                }
            }
        }
    }

    public void mergeToTheRight() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length - 1; j++) {
				if (board[i][j].getValue() != 0) {
					if (board[i][j].getValue() == board[i][j+1].getValue()) {
						board[i][j+1].setValue(board[i][j+1].getValue()*2);
						board[i][j].setValue(0);
					}
				}
			}
		}
    }

    public boolean isGameOver(){
        if (getEmptyCells().isEmpty()){
            //check if the contiguous cells are equal
            for (int i = 0; i < board.length; i++) {
            	for (int j = 0; j < board[i].length; j++) {
                    if (j < board[i].length - 1){ //check the right value
                        if(board[i][j].getValue() == board[i][j + 1].getValue()) return false;
                    }
                    if (j > 0){ //check the left value
                        if(board[i][j].getValue() == board[i][j - 1].getValue()) return false;
                    }
                    if (i < board.length - 1){ //check the value below
                        if(board[i][j].getValue() == board[i + 1][j].getValue()) return false;
                    }
                    if (i > 0){ //check the value above
                        if(board[i][j].getValue() == board[i - 1][j].getValue()) return false;
                    }
            	}
            }
            return true;
        }
        return false;
    }
}