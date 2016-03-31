
package board;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import Code.Tile.RealTile;
import path.Path;
import path.PathCollections;
import pawn.Pawn;

public class Board {
	
	private int COLS = 7;
	private int ROWS = COLS;
	private PathCollections _pColl;
	private RealTile _leftover;
	private ArrayList<ArrayList<RealTile>> _tempBoard;
	private RealTile[][] _board ={ {/** */new RealTile(null, new Path(false,true,false,true)), /** */null, /** */new RealTile(null, new Path(false,true,true,true)), /** */null, /** */new RealTile(null, new Path(false,true,true,true)), /** */null, /** */new RealTile(null, new Path(false,true,true,false))},                                                                   
								   {/** */null, /** */null, /** */null, /** */null, /** */null},
								   {/** */new RealTile(null, new Path(true,true,false,true)), /** */null, /** */new RealTile(new Pawn("r"), new Path(true,true,false,true)), /** */null, /** */new RealTile(new Pawn("y"), new Path(false,true,true,true)), /** */null, /** */new RealTile(null, new Path(true,true,true,false))},
								   {/** */null, /** */null, /** */null, /** */null, /** */null},
								   {/** */new RealTile(null, new Path(true,true,false,true)), /** */null, /** */new RealTile(new Pawn("w"), new Path(true,false,true,true)), /** */null, /** */new RealTile(new Pawn("b"), new Path(true,true,true,false)), /** */null, /** */new RealTile(null, new Path(true,true,true,false))},
								   {/** */null, /** */null, /** */null, /** */null, /** */null},
								   {/** */new RealTile(null, new Path(true,false,false,true)), /** */null, /** */new RealTile(null, new Path(true,false,true,true)), /** */null, /** */new RealTile(null, new Path(true,false,true,true)), /** */null, /** */new RealTile(null, new Path(true,false,true,false))},
	}; //this is a mess, but is the board at the start;
	
	public Board() {
		populateBoard();
		_pColl = new PathCollections();
	}
		
	public void populateBoard() {
		ArrayList<Path> pList = _pColl.getList();
		for(int col=0; col<COLS; col++) {
			for(int row=0; row<ROWS; row++) {
				if(_board[col][row] != null) {
				
			} else {
				_board[row][col] = new RealTile(null, pList.get(1));
				pList.remove(1);//hope this works if not cry
			}
		  }
	   }
		_leftover = new RealTile(null,pList.get(1));
	}
	
    public Pawn findPlayer(String s) {
    	for(int col=0; col<COLS; col++) {
			for(int row=0; row<ROWS; row++) {
				Pawn pap = _board[col][row].getPawn();
				if(pap!=null && pap.getColor()==s) {
					//set there turn tile equal to this.
				}
			}
    	} //idk if i need this anymore
		return null;
	}
    
    public void shiftBoard(int x, int y) {
    	RealTile temp = new RealTile(null,null);
    	if(x==0){
    		if(y==1){
    			for(int i=6; i>=0; i--){
    				_board[1][6].
    			}
    		}
    		else if(y==3){
    			
    		}
    		else if(y==5){
    			
    		}	
    	}else if(x==0){
    		if(y==1){
    			
    		}
    		else if(y==3){
    			
    		}
    		else if(y==5){
    			
    		}
    	}else if(y==0){
    		if(x==1){
    			
    		}
    		else if(x==3){
    			
    		}
    		else if(x==5){
    			
    		}
    	}else if(y==6){
            if(x==1){
    			
    		}
    		else if(x==3){
    			
    		}
    		else if(x==5){
    			
    		}
    	}
    }
}
