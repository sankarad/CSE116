
package board;

import java.util.ArrayList;
import java.util.Collections;

import Code.Tile.Ingredient;
import Code.Tile.RealTile;
import path.Path;
import path.PathCollections;
import pawn.Pawn;

public class Board {
	
	private int COLS = 7;
	private int ROWS = COLS;
	private PathCollections _pColl;
	private RealTile _leftover;
	private RealTile[][] _board = { {/** */new RealTile(null, new Path(false,true,false,true),null), /** */null, /** */new RealTile(null, new Path(false,true,true,true),null), /** */null, /** */new RealTile(null, new Path(false,true,true,true),null), /** */null, /** */new RealTile(null, new Path(false,true,true,false),null)},                                                                   
		   {/** */null, /** */null, /** */null, /** */null, /** */null, /** */null, /** */null},
		   {/** */new RealTile(null, new Path(true,true,false,true),null), /** */null, /** */new RealTile(new Pawn("r",2,2), new Path(true,true,false,true),null), /** */null, /** */new RealTile(new Pawn("y",4,2), new Path(false,true,true,true),null), /** */null, /** */new RealTile(null, new Path(true,true,true,false),null)},
		   {/** */null, /** */null, /** */null, /** */null, /** */null, /** */null, /** */null},
		   {/** */new RealTile(null, new Path(true,true,false,true),null), /** */null, /** */new RealTile(new Pawn("w",2,4), new Path(true,false,true,true),null), /** */null, /** */new RealTile(new Pawn("b",4,4), new Path(true,true,true,false),null), /** */null, /** */new RealTile(null, new Path(true,true,true,false),null)},
		   {/** */null, /** */null, /** */null, /** */null, /** */null, /** */null, /** */null},
		   {/** */new RealTile(null, new Path(true,false,false,true),null), /** */null, /** */new RealTile(null, new Path(true,false,true,true),null), /** */null, /** */new RealTile(null, new Path(true,false,true,true),null), /** */null, /** */new RealTile(null, new Path(true,false,true,false),null)},
};
	private int _activePawnX;
	private int _activePawnY;
	
	public Board() {
		_pColl = new PathCollections();
	//	initializeBoard(_board);
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
		for(int y=0; y<COLS; y++) {
			for(int x=0; x<ROWS; x++) {
				if(_board[x][y] == null) {
					_board[x][y] = new RealTile(null, _pColl.getList().get(0),null);
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
				_board[x][y].setIngredient(new Ingredient(list.get(0)));
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
    
    public void ShiftBoardR(){// Moves to the end of the row and the does process backwards
    	int x=1;
    	RealTile temp;
    	temp=_board[x][6];
    	for(int i=6; i>1 ; i=i-1)
    	{
    		_board[x][i]= _board[x][i-1];
    	}
    	_board[1][0]=_leftover;
    	_leftover=temp;
    	
    }
    public void ShiftBoardR1(){// Moves to the end of the row and the does process backwards
    	int x=3;
    	RealTile temp;
    	temp=_board[x][6];
    	for(int i=6; i>1 ; i=i-1)
    	{
    		_board[x][i]= _board[x][i-1];
    	}
    	_board[3][0]=_leftover;
    	_leftover=temp;
    	
    }
    public void ShiftBoardR2(){// Moves to the end of the row and the does process backwards
    	int x=5;
    	RealTile temp;
    	temp=_board[x][6];
    	for(int i=6; i>1 ; i=i-1)
    	{
    		_board[x][i]= _board[x][i-1];
    	}
    	_board[5][0]=_leftover;
    	_leftover=temp;
    	
    }
    public void ShiftBoardL(){// Moves to the end of the row and the does process backwards
    	int x=1;
    	RealTile temp;
    	temp=_board[x][0];
    	for(int i=1; i<6 ; i++)
    	{
    		_board[x][i]= _board[x][i+1];
    	}
    	_board[x][6]=_leftover;
    	_leftover=temp;
    }
    public void ShiftBoardL1(){// Moves to the end of the row and the does process backwards
    	int x=3;
    	RealTile temp;
    	temp=_board[x][0];
    	for(int i=1; i<6 ; i++)
    	{
    		_board[x][i]= _board[x][i+1];
    	}
    	_board[x][6]=_leftover;
    	_leftover=temp;
    }
    public void ShiftBoardL2(){// Moves to the end of the row and the does process backwards
    	int x=5;
    	RealTile temp;
    	temp=_board[x][0];
    	for(int i=1; i<6 ; i++)
    	{
    		_board[x][i]= _board[x][i+1];
    	}
    	_board[x][6]=_leftover;
    	_leftover=temp;
    }

    public void ShiftBoardD(){// Moves to the end of the column and the does process backwards
    	int y=1;
    	RealTile temp;
    	temp=_board[6][y];
    	for(int i=6; i>1 ; i=i-1)
    	{
    		_board[i][y]= _board[i-1][y];
    	}
    	_board[0][y]=_leftover;
    	_leftover=temp;
    	
    }
    public void ShiftBoardD1(){// Moves to the end of the column and the does process backwards
    	int y=3;
    	RealTile temp;
    	temp=_board[6][y];
    	for(int i=6; i>1 ; i=i-1)
    	{
    		_board[i][y]= _board[i-1][y];
    	}
    	_board[0][y]=_leftover;
    	_leftover=temp;
    	
    }
    public void ShiftBoardD2(){// Moves to the end of the column and the does process backwards
    	int y=5;
    	RealTile temp;
    	temp=_board[6][y];
    	for(int i=6; i>1 ; i=i-1)
    	{
    		_board[i][y]= _board[i-1][y];
    	}
    	_board[0][y]=_leftover;
    	_leftover=temp;
    }
    public void ShiftBoardUp(){// Moves to the end of the column and the does process backwards
    	int y=1;
    	RealTile temp;
    	temp=_board[0][y];
    	for(int i=1; i<6 ; i++)
    	{
    		_board[i][y]= _board[i+1][y];
    	}
    	_board[6][y]=_leftover;
    	_leftover=temp;
    	
    }
    public void ShiftBoardUp1(){// Moves to the end of the column and the does process backwards
    	int y=3;
    	RealTile temp;
    	temp=_board[0][y];
    	for(int i=1; i<6 ; i++)
    	{
    		_board[i][y]= _board[i+1][y];
    	}
    	_board[6][y]=_leftover;
    	_leftover=temp;
    	
    }
    public void ShiftBoardUp2(){// Moves to the end of the column and the does process backwards
    	int y=5;
    	RealTile temp;
    	temp=_board[0][y];
    	for(int i=1; i<6 ; i++)
    	{
    		_board[i][y]= _board[i+1][y];
    	}
    	_board[6][y]=_leftover;
    	_leftover=temp;
    	
    }
    public RealTile GetLeftover(){
		return _leftover;
    	
    }
}


















