package Code.Tile;

import path.Path;
import pawn.Pawn;

public class RealTile extends TileTemplate {
	
	private Pawn _pawn;
	private Path _path;
	private Ingredient _ingredient;
	
	public RealTile(Pawn pawn, Path path, Ingredient ingredient){
		_pawn = pawn;
		_path = path;
		_ingredient = ingredient;
	}

	@Override
	public void setPath(Path path) {
		_path = path;
	}

	@Override
	public Path getPath() {
		return _path;
	}
	

	@Override
	public void setPawn(Pawn pawn) {
		_pawn = pawn;
	}

	@Override
	public Pawn getPawn() {
		return _pawn;
	}

	@Override
	public void removePawn() {
		setPawn(null);
	}

	@Override
	public void setIngredient(Ingredient ingredient) {
		_ingredient = ingredient;
		
	}

	@Override
	public Ingredient getIngredient() {
		return _ingredient;
	}
	
}
