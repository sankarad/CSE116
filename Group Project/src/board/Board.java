
package board;

import java.util.ArrayList;
import java.util.Collections;

import Code.Tile.RealTile;
import path.Path;
import path.PathCollections;
import pawn.Pawn;

public class Board {
	
	private int COLS = 7;
	private int ROWS = COLS;
	private PathCollections _pColl;
	private RealTile _leftover;
	private RealTile[][] _board; 
	private int _activePawnX;
	private int _activePawnY;
	
	public Board() {
		_pColl = new PathCollections();
		initializeBoard(_board);
		populateBoard();
		placeIngredients();
	}
	
	public void initializeBoard(RealTile[][] board) { //call this method to make the default board
		board = new RealTile[][]{ {/** */new RealTile(null, new Path(false,true,false,true),null), /** */null, /** */new RealTile(null, new Path(false,true,true,true),null), /** */null, /** */new RealTile(null, new Path(false,true,true,true),null), /** */null, /** */new RealTile(null, new Path(false,true,true,false),null)},                                                                   
				   {/** */null, /** */null, /** */null, /** */null, /** */null},
				   {/** */new RealTile(null, new Path(true,true,false,true),null), /** */null, /** */new RealTile(new Pawn("r",2,2), new Path(true,true,false,true),null), /** */null, /** */new RealTile(new Pawn("y",4,2), new Path(false,true,true,true),null), /** */null, /** */new RealTile(null, new Path(true,true,true,false),null)},
				   {/** */null, /** */null, /** */null, /** */null, /** */null},
				   {/** */new RealTile(null, new Path(true,true,false,true),null), /** */null, /** */new RealTile(new Pawn("w",2,4), new Path(true,false,true,true),null), /** */null, /** */new RealTile(new Pawn("b",4,4), new Path(true,true,true,false),null), /** */null, /** */new RealTile(null, new Path(true,true,true,false),null)},
				   {/** */null, /** */null, /** */null, /** */null, /** */null},
				   {/** */new RealTile(null, new Path(true,false,false,true),null), /** */null, /** */new RealTile(null, new Path(true,false,true,true),null), /** */null, /** */new RealTile(null, new Path(true,false,true,true),null), /** */null, /** */new RealTile(null, new Path(true,false,true,false),null)},
};
	}
		
	public void populateBoard() {
		//ArrayList<Path> pList = _pColl.getList();
		for(int col=0; col<COLS; col++) {
			for(int row=0; row<ROWS; row++) {
				if(_board[col][row] == null) {
					_board[row][col] = new RealTile(null, _pColl.getList().get(0),null);
					_pColl.getList().remove(0); //hope this works if not cry, it should use the first value the remove it, shifting the rest
			} 
		  }
	   }
		_leftover = new RealTile(null,_pColl.getList().get(0),null); //assign leftover to the leftover randomized tile.
	}
	
	public void placeIngredients() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<27; i++){
			list.add(i);
		}
		Collections.shuffle(list);
		for(int y=1; y<6; y++) {
			for(int x=1; x<6; x++) {
				_board[x][y].getIngredient().setNum(list.get(0));
				list.remove(0);
			}
		}
	}
	
	public void findPlayer(String s) {
		for(int y=0; y<COLS; y++) {
			for(int x=0; x<ROWS; x++) {
				Pawn p = _board[x][y].getPawn();
				if(p != null) { //if the tile has a pawn on it
					if(p.getColor().length() == 1) { // if the tile has only one pawn on it
						if(s == p.getColor()) { //checks if the Pawn is the one we want to find
							_activePawnX = p.getX();
							_activePawnY = p.getY();
						}
					} else { // if the tile has more than one pawn on it
						if(p.getColor().contains(s)){ //check if the string contains our desired pawn
							_activePawnX = p.getX();
							_activePawnY = p.getY();
						}
					}
				}
			}
		}
	}
    
    public void movePawn(int direction) {
    	if(direction == 87) { //up
    		if(_board[_activePawnX][_activePawnY-1].getPath().isBottomOpen()){ //check if the path at pos. is true
    		_board[_activePawnX][_activePawnY-1].setPawn(_board[_activePawnX][_activePawnY].getPawn()); // change to the new pawn if true
    		_board[_activePawnX][_activePawnY].removePawn();//set Pawn equal to zero
    		_activePawnX = _board[_activePawnX][_activePawnY-1].getPawn().getX(); //change the x and y to the new tile pawn pos.
    		_activePawnY = _board[_activePawnX][_activePawnY-1].getPawn().getY();
    		}
    	}
    	if(direction == 65) { //left
    		if(_board[_activePawnX-1][_activePawnY].getPath().isBottomOpen()){
    		_board[_activePawnX-1][_activePawnY].setPawn(_board[_activePawnX][_activePawnY].getPawn());
    		_board[_activePawnX][_activePawnY].removePawn();
    		_activePawnX = _board[_activePawnX-1][_activePawnY].getPawn().getX(); //change the x and y to the new tile pawn pos.
    		_activePawnY = _board[_activePawnX-1][_activePawnY].getPawn().getY();
    		}
    	}
    	if(direction == 83) { //down
    		if(_board[_activePawnX][_activePawnY+1].getPath().isBottomOpen()){
    		_board[_activePawnX][_activePawnY-1].setPawn(_board[_activePawnX][_activePawnY].getPawn());
    		_board[_activePawnX][_activePawnY].removePawn();
    		_activePawnX = _board[_activePawnX][_activePawnY+1].getPawn().getX(); //change the x and y to the new tile pawn pos.
    		_activePawnY = _board[_activePawnX][_activePawnY+1].getPawn().getY();
    		}
    	}
    	if(direction == 68) { //right
    		if(_board[_activePawnX+1][_activePawnY].getPath().isBottomOpen()){
    		_board[_activePawnX+1][_activePawnY].setPawn(_board[_activePawnX][_activePawnY].getPawn());
    		_board[_activePawnX][_activePawnY].removePawn();
    		_activePawnX = _board[_activePawnX+1][_activePawnY].getPawn().getX(); //change the x and y to the new tile pawn pos.
    		_activePawnY = _board[_activePawnX+1][_activePawnY].getPawn().getY();
    		}
    	}
    }
    
    public void ShiftBoard(int x, int y){
    	
    }
    
    public RealTile GetLeftover(){
		return _leftover;
    	
    }
}


















