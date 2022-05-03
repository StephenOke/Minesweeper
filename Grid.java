
//https://youtu.be/gojAvWWCybc
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Grid { //extends JFrame{
private Boolean[][] bombGrid;
private int[][] countGrid;
private int numRows;
private int numColumns;
private int numBombs;
private int numClicks;
private JButton[][] button;
 
public Grid() {
	numRows =10;
	numColumns =10;
	numBombs =25;
	bombGrid = new Boolean[numRows][numColumns];
	countGrid = new int[numRows][numColumns];
	numClicks = ((numRows * numColumns)-numBombs);
	createBombGrid();
	createCountGrid();
	
}
public Grid(int rows, int cols) {
	numRows =rows;
	numColumns =cols;
	numBombs =25;
	bombGrid = new Boolean[numRows][numColumns];
	countGrid = new int[numRows][numColumns];
	numClicks = ((numRows * numColumns)-numBombs);
	createBombGrid();
	createCountGrid();
	
}
public Grid(int rows, int cols, int bombs) {
	numRows =rows;
	numColumns =cols;
	numBombs =bombs;
	bombGrid = new Boolean[numRows][numColumns];
	countGrid = new int[numRows][numColumns];
	numClicks = ((numRows * numColumns)-numBombs);
	createBombGrid();
	createCountGrid();
	
}
public int getNumRows() {
	return numRows;
}
public int getNumColumns() {
	return numColumns;
}
public int getNumBombs() {
	return numBombs;
}
public boolean[][] getBombGrid(){
	boolean[][] bombGridCopy = new boolean[numRows][numColumns];
	for(int row = 0; row < numRows; row++) {
		for(int col = 0; col < numColumns; col++) {
			bombGridCopy[row][col] = bombGrid[row][col];
		}
	}
	return bombGridCopy;
}
public int[][] getCountGrid(){
	int[][] countGridCopy = new int[numRows][numColumns];
	for(int row=0; row < numRows; row++) {
		for(int col =0; col < numColumns; col++) {
			countGridCopy[row][col] = countGrid[row][col];
		}
	}
	return countGridCopy;	
}
public boolean isBombAtLocation(int rows, int cols) {
	if(bombGrid[rows][cols] != true) {
		return false;
	}
	else
		return true;
}
public int getCountAtLocation(int row, int col) {
	if(row < 0) {
		return countGrid[0][col];
	}
	if(col < 0) {
		return countGrid[row][0];
	}
	if(row >= numRows) {
		return countGrid[numRows -1][col];
	}
	if(col >= numColumns) {
		return countGrid[row][numColumns-1];
	}
	if(row < 0 && col < 0) {
		return countGrid[0][0];
	}
	if(row >= numRows && col >= numColumns) {
		return countGrid[numRows -1][numColumns-1];
	}
	if( row < 0 && col >= numColumns) {
		return countGrid[0][numColumns-1];
	}
	if(row >= numRows && col < 0) {
		return countGrid[numRows -1][0];
	}
	else
		return countGrid[row][col];
}
private void createCountGrid() {
	for(int row = 0; row < numRows ; row++) {
		for(int col = 0; col < numColumns; col++) {
			int counter = 0; 
			try {
				if(bombGrid[row][col] ==  true) {
					counter++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			try {
				if(bombGrid[row][col +1] == true) {
					counter++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			try {
				if(bombGrid[row][col -1] == true) {
					counter++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			try {
				if(bombGrid[row +1][col] == true) {
					counter++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			try {
				if(bombGrid[row -1][col] == true) {
					counter++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			try {
				if(bombGrid[row +1][col -1] == true) {
					counter++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			try {
				if(bombGrid[row -1][col +1] == true) {
					counter++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			try {
				if(bombGrid[row +1][col +1] == true) {
					counter++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			try {
				if(bombGrid[row -1][col -1] == true) {
					counter++;
				}
			}catch(ArrayIndexOutOfBoundsException e) {
				
			}
			countGrid[row][col] =counter;
		}
	}
}
private void createBombGrid() {
	for(int row =0; row < numRows; row++) {
		for(int col =0; col < numColumns; col++) {
			bombGrid[row][col] = false;
		}
	}
	for( int i =0;i < numBombs; i++) {
		int rows = (int)(Math.random()*(numRows -1));
		int cols = (int)(Math.random()*(numColumns -1));
		if(bombGrid[rows][cols] == true) {
			i = i-1;
		}
		else {
			bombGrid[rows][cols] =true;
		}
	}
}

}
