
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
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.GridLayout;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
// class minesweeperGUI {
//
//
//	public static void main(String[] args) {
//		 JFrame frame= new JFrame();
//		 frame.setLayout(new BorderLayout());// might change to gridLyaout just to peep
//		 JPanel gridPanel =new JPanel();
//		
//		 frame.add(gridPanel, BorderLayout.CENTER);
//		 
//		 minesweeper(gridPanel);
//		 
//		frame.setResizable(false);
//		 frame.setSize(800,800);
//		 frame.setLocationRelativeTo(null);
//		 frame.setVisible(true);
//	}
//		 public static void minesweeper(JPanel gridPanel) {
//			 gridPanel.removeAll();
//			 
//			 Grid grid = new Grid(); //you can change the values or numrows, columns and bombs
//			 gridPanel.setLayout(new GridLayout(grid.getNumRows(), grid.getNumColumns()));
//			 final int[] numClicks = new int[1];
//			 numClicks[0] = grid.getNumRows()*grid.getNumColumns()-grid.getNumBombs();
//			 
//			 for(int row = 0; row < grid.getNumRows(); row++) {
//				 for(int col= 0; col < grid.getNumColumns(); col++) {
//					 JButton button = new JButton();
//					 
//					 button.setActionCommand(row +" "+col);
//					 
//					 button.addActionListener(new ActionListener() {
//						 ImageIcon boomImg = new ImageIcon("images/boomIcon.jpg");
//							ImageIcon boomImgScaled = new ImageIcon(boomImg.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
//                               
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							JButton button = (JButton)e.getSource();
//							button.setBackground(Color.ORANGE);
//							String str = e.getActionCommand();
//							String[] coordinates= str.split(" ");
//							int buttonrows = Integer.parseInt(coordinates[0]);
//							int buttonCols = Integer.parseInt(coordinates[1]);
//							int game = 0;
//							 if(grid.isBombAtLocation(buttonrows, buttonCols)) {
//								 game=  -1;
//							
//								 button.setIcon(boomImgScaled);
//							 }else {
//								 button.setText(grid.getCountAtLocation(buttonrows, buttonCols)+"");
//								 button.setEnabled(false);
//								
//								 numClicks[0]--;
//								 
//								 if(numClicks[0]==0) {
//									 game = 1;
//								 }
//							 }
//							 if(game != 0) {
//								 String title= "GAME OVER";
//								 String message= " do you want to play again??";
//								 if(game ==1) {
//									 message = " OMG CONGRATUATIONS YOU WON!!"+message;
//								 }else {
//									 message ="You lost haha."+message;
//								 }
//								 int showOption = JOptionPane.showConfirmDialog(gridPanel, message,title,JOptionPane.YES_NO_OPTION);
//								 if(showOption == JOptionPane.YES_OPTION) {
//									minesweeper(gridPanel);
//								 }else {
//									 System.exit(0);
//								 }
//							 }
//							
//						}
//						
//					 });
//						 
//					 gridPanel.add(button);
//				 }
//				 gridPanel.revalidate();
//				 gridPanel.repaint();
//				
//			 }
//			
//		 }
//
//	
//
//}
