
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

 class minesweeperGUI {


	public static void main(String[] args) {
		 JFrame frame= new JFrame();
		 frame.setLayout(new BorderLayout());// might change to gridLyaout just to peep
		 JPanel gridPanel =new JPanel();
		
		 frame.add(gridPanel, BorderLayout.CENTER);
		 
		 minesweeper(gridPanel);
		 
		frame.setResizable(false);
		 frame.setSize(800,800);
		 frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
	}
		 public static void minesweeper(JPanel gridPanel) {
			 gridPanel.removeAll();
			 
			 Grid grid = new Grid(10,10,10);
			 gridPanel.setLayout(new GridLayout(grid.getNumRows(), grid.getNumColumns()));
			 final int[] numClicks = new int[1];
			 numClicks[0] = grid.getNumRows()*grid.getNumColumns()-grid.getNumBombs();
			 
			 for(int row = 0; row < grid.getNumRows(); row++) {
				 for(int col= 0; col < grid.getNumColumns(); col++) {
					 JButton button = new JButton();
					 
					 button.setActionCommand(row +" "+col);
					 
					 button.addActionListener(new ActionListener() {
						 ImageIcon boomImg = new ImageIcon("images/boomIcon.jpg");
							ImageIcon boomImgScaled = new ImageIcon(boomImg.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
                               
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton button = (JButton)e.getSource();
							button.setBackground(Color.ORANGE);
							String str = e.getActionCommand();
							String[] coordinates= str.split(" ");
							int buttonrows = Integer.parseInt(coordinates[0]);
							int buttonCols = Integer.parseInt(coordinates[1]);
							int game = 0;
							 if(grid.isBombAtLocation(buttonrows, buttonCols)) {
								 game=  -1;
							
								 button.setIcon(boomImgScaled);
							 }else {
								 button.setText(grid.getCountAtLocation(buttonrows, buttonCols)+"");
								 button.setEnabled(false);
								
								 numClicks[0]--;
								 
								 if(numClicks[0]==0) {
									 game = 1;
								 }
							 }
							 if(game != 0) {
								 String title= "GAME OVER";
								 String message= " do you want to play again??";
								 if(game ==1) {
									 message = " OMG CONGRATUATIONS YOU WON!!"+message;
								 }else {
									 message ="You lost haha."+message;
								 }
								 int showOption = JOptionPane.showConfirmDialog(gridPanel, message,title,JOptionPane.YES_NO_OPTION);
								 if(showOption == JOptionPane.YES_OPTION) {
									minesweeper(gridPanel);
								 }else {
									 System.exit(0);
								 }
							 }
							
						}
						
					 });
						 
					 gridPanel.add(button);
				 }
				 gridPanel.revalidate();
				 gridPanel.repaint();
				
			 }
			
		 }

	

}
