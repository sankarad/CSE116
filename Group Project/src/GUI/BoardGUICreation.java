package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import board.Board;



public class BoardGUICreation {
	private Board _board = new Board();

	
	static JFrame board=new JFrame("Labyrinth Game");
	static JButton[][] buttons;
	
	public BoardGUICreation(){
		
		JPanel pane = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		buttons=new JButton[7][7];
		for(int x=0;x<7;x++){
			for(int y=0;y<7;y++){
				buttons[y][x]=new JButton("  ");
				c.gridx = y+1;
				c.gridy = x+1;
				c.ipady = 80;      
				c.ipadx = 80;      
				pane.add(buttons[y][x],c);
				
				
			
			}
		}
		
		JButton movementButton1 = new JButton("Down");
		c.gridx = 2; 
		c.gridy = 0;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(0,0,10,0); 
		pane.add(movementButton1, c);
		JButton movementButton2 = new JButton("Down");
		c.gridx = 4; 
		c.gridy = 0;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(0,0,10,0); 
		pane.add(movementButton2, c);
		JButton movementButton3 = new JButton("Down");
		c.gridx = 6; 
		c.gridy = 0;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(0,0,10,0); 
		pane.add(movementButton3, c);
		JButton movementButton4 = new JButton("Left");
		c.gridx = 8; 
		c.gridy = 2;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(0,10,0,0); 
		pane.add(movementButton4, c);
		JButton movementButton5 = new JButton("Left");
		c.gridx = 8; 
		c.gridy = 4;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(0,10,0,0); 
		pane.add(movementButton5, c);
		JButton movementButton6 = new JButton("Left");
		c.gridx = 8; 
		c.gridy = 6;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(0,10,0,0); 
		pane.add(movementButton6, c);
		JButton movementButton7 = new JButton("Up");
		c.gridx = 6; 
		c.gridy = 8;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(10,0,0,0); 
		pane.add(movementButton7, c);
		JButton movementButton8 = new JButton("Up");
		c.gridx = 4; 
		c.gridy = 8;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(10,0,0,0); 
		pane.add(movementButton8, c);
		JButton movementButton9 = new JButton("Up");
		c.gridx = 2; 
		c.gridy = 8;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(10,0,0,0); 
		pane.add(movementButton9, c);
		JButton movementButton10 = new JButton("Right");
		c.gridx = 0; 
		c.gridy = 6;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(0,0,0,10); 
		pane.add(movementButton10, c);
		JButton movementButton11 = new JButton("Right");
		c.gridx = 0; 
		c.gridy = 4;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(0,0,0,10); 
		pane.add(movementButton11, c);
		JButton movementButton12 = new JButton("Right");
		c.gridx = 0; 
		c.gridy = 2;
		c.ipady = 40;
		c.ipadx = 50;
		c.insets = new Insets(0,0,0,10); 
		pane.add(movementButton12, c);
		
		JButton movementClockwiseButton = new JButton("Rotate Clockwise");
		c.gridx = 15;
		c.gridy = 1;
		c.ipady = 75;
		c.ipadx = 125;
		c.insets = new Insets(0,80,0,0);
		pane.add(movementClockwiseButton, c);
		

		movementClockwiseButton.addActionListener(new ClockwiseEventHandler(_board,_board.GetLeftover()));
				
			
				
		
/*		JButton movementCounterClockwiseButton = new JButton("Rotate Counter-Clockwise");
		c.gridx = 16;
		c.gridy = 1;
		c.ipady = 75;
		c.ipadx = 85;
		c.insets = new Insets(0,0,0,0);
		pane.add(movementCounterClockwiseButton, c);*/
		
		JButton nextTilePlaced = new JButton("Next Tile Here");
		c.gridx = 15;
		c.gridy = 2;
		c.ipady = 60;
		c.ipadx = 60;
		c.insets = new Insets(00,70,0,0);
		pane.add(nextTilePlaced, c);
		
		JButton endTurnWithoutMovingButton = new JButton("End Without Moving");
		c.gridx = 15;
		c.gridy = 4;
		c.ipady = 40;
		c.ipadx = 100;
		c.insets = new Insets(0,80,0,0);
		pane.add(endTurnWithoutMovingButton, c);
		
		JButton PickUpToken = new JButton("Pick Up Token");
		c.gridx = 15;
		c.gridy = 3;
		c.ipady = 40;
		c.ipadx = 100;
		c.insets = new Insets(0,80,0,0);
		pane.add(PickUpToken, c);
		
		
		String playerLoadout1 = "Player 1: " + "   Player 1 Name" + "   Score";
		String playerLoadout2 = "Player 2: " + "   Player 2 Name" + "   Score";
		String playerLoadout3 = "Player 3: " + "   Player 3 Name" + "   Score";
		String playerLoadout4 = "Player 4: " + "   Player 4 Name" + "   Score";
		//c.insets = new Insets (00,00,00,00);
		JLabel label = new JLabel(playerLoadout1);
		c.gridx = 15;
		c.gridy = 5;
		pane.add(label, c);
		JLabel label2 = new JLabel(playerLoadout2);
		c.gridx = 15;
		c.gridy = 6;
		pane.add(label2, c);
		JLabel label3 = new JLabel(playerLoadout3);
		c.gridx = 15;
		c.gridy = 7;
		pane.add(label3, c);
		JLabel label4 = new JLabel(playerLoadout4);
		c.gridx = 15;
		c.gridy = 8;
		pane.add(label4, c);
		
		board.add(pane);
	//	pane.setSize(1000,1000);
		//board.getContentPane().setLayout(new FlowLayout());
		board.setSize(1700,1000);
		//board.pack();
		board.setVisible(true);//set board visibility here
		pane.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new BoardGUICreation(); //makes new Board
	}
	
	

	}



	

