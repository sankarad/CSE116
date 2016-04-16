package GUI;

import java.util.Scanner;

import javax.swing.SwingUtilities;
import GUI.BoardGUICreation;

public class Driver {
	public static void main(String[] args) {
		
		System.out.println("Enter Number of Players: ");
		Scanner players= new Scanner(System.in);
		String p= "";
		int num= players.nextInt();
		if(num<2 || num >4){System.out.println("Impossible to play3");}
		else{
		for(int i=0;i<num; i=i+1){
		Scanner name=new Scanner(System.in);
		System.out.println("Enter Player: ");
		String pname= name.next();
		p= p +" " + pname;
		}
		System.out.println("Num of players: "+num+ "\n Players: "+ p);
		SwingUtilities.invokeLater((Runnable) new BoardGUICreation());
		}
		
	}
}
