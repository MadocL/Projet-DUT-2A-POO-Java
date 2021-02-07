package model;

public class Cell {
	private int value;
	
	public Cell (int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public String toString(){
		return Integer.toString(value);
	}
}
