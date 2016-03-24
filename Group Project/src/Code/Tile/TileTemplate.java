package Code.Tile;

public abstract class TileTemplate {
	public abstract void setPath(Path path);
	public abstract Path getPath();
	public abstract void setPawn(Pawn pawn);
	public abstract Pawn getPawn();
	public abstract void setToken(Token token);
	public abstract Token getToken();
	public abstract void shiftTiles(); 
}
