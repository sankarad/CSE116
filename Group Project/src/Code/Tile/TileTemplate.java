package Code.Tile;

import path.Path;
import pawn.Pawn;

public abstract class TileTemplate {
	public abstract void setPath(Path path);
	public abstract Path getPath();
	public abstract void setPawn(Pawn pawn);
	public abstract Pawn getPawn();
//	public abstract void setIngredient(Ingredient ingredient);
//	public abstract Ingredient getIngredient(); 
}
