package Code.Tile;

import java.util.ArrayList;

import path.Path;

public class TileCollections {
	private ArrayList<RealTile> _list;
	
	public TileCollections() {
		
	}
	
	public void makeTileList() {
		Path p = new Path(false,false,false,false);
		for(int i=0; i<13; i++) {
			_list.add(p.makeCornerPath());
		}
	}
}
