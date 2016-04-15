package path;

import java.util.ArrayList;
import java.util.Collections;

public class PathCollections {
	private ArrayList<Path> _list;
	
	public PathCollections() {
		_list = new ArrayList<Path>();
		makePathList();
	}
	
	public void makePathList() { /* this makes a list of all the different available paths and randomizes them**/
		Path p = new Path(false,false,false,false);
		for(int i=0; i<15; i++) {
			p = p.randomizePath(p.makeCornerPath());
			_list.add(p);
		}
		for(int i=0; i<13; i++) {
			p = p.randomizePath(p.makeStraightPath());
			_list.add(p);
		}
		for(int i=0; i<6; i++) {
			p = p.randomizePath(p.makeTPath());
			_list.add(p);
		}
		Collections.shuffle(_list);
	}
	
	public ArrayList<Path> getList() {
		return _list;
	}
}
