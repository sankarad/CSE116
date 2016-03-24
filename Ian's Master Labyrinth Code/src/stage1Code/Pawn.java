package stage1Code;

public abstract class Pawn {
	public int x, y;
	public Player player;
	
	/**
	 * Constructor for the pawns
	 * @param x is the x location of the pawn
	 * @param y is the y location of the pawn
	 * @param player is the player object associated with the pawn (blue player, red player, etc...)
	 */
	
	public Pawn (int x, int y, Player player){
		this.x = x;
		this.y = y;
		//this.player = player;
		//player.game.gameBoard.boardArray [x][y] = this;
	}
	
	/**
	 * Determines if the pawns path is valid based on the walls of the maze
	 * @param finalX is the final X location
	 * @param finalY is the final Y location 
	 * @return A boolean indicating whether the path is valid
	 */
	public abstract boolean isValidPath(int finalX, int finalY);
	
	/**
	 * Draws a path from one point to another based on the players desired end location
	 * @param startX is the initial X location
	 * @param startY is the initial Y location
	 * @param finalX is the final X location
	 * @param finalY is the final Y location
	 */
	public abstract int[][] drawPath(int startX, int startY, int finalX, int finalY);
	
	
	
	
	
}
