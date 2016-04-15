package path;

import java.util.Random;

public class Path {
	
	private boolean _top;
	private boolean _bottom;
	private boolean _left;
	private boolean _right;
	private Random _r;
	
	public Path(boolean top, boolean bottom, boolean left, boolean right) { //can simplify this to take one parameter and use ifs
	 	_top = top;
		_bottom = bottom;
		_left = left;
		_right = right;
		_r = new Random();
	}
	
	public boolean isTopOpen() {
		return _top;
	}
	
	public boolean isBottomOpen() {
		return _bottom;
	}
	
	public boolean isLeftOpen() {
		return _left;
	}
	
	public boolean isRightOpen() {
		return _right;
	}
	
	public void setTop(boolean b) {
		_top = b;
	}
	
	public void setBottom(boolean b) {
		_bottom = b;
	}
	
	public void setLeft(boolean b) {
		_left = b;
	}
	
	public void setRight(boolean b) {
		_right = b;
	}
	
	public Path rotate(Path oldPath) {
		Path newPath = new Path(false,false,false,false);
		if(oldPath.isLeftOpen()){
			newPath.setTop(true);
		} 
		if(oldPath.isBottomOpen()){
			newPath.setLeft(true);
		}
		if(oldPath.isRightOpen()){
			newPath.setBottom(true);
		}
		if(oldPath.isTopOpen()){
			newPath.setRight(true);
		}
		return newPath;
	}
	
	public Path makeCornerPath() {
		return new Path(true,false,true,false);
	}
	
	public Path makeTPath() {
		return new Path(true,false,true,true);
	}
	
	public Path makeStraightPath() {
		return new Path(false,false,true,true);
	}
	//make sure its not easier to just make these methods in the board class instead.
	
	public Path randomizePath(Path path) {
		int num = _r.nextInt(3);
		if(num==1){
			path = rotate(path);
		}else if(num==2){
			path = rotate(path);
			path = rotate(path);
		}else if(num==3){
			path = rotate(path);
			path = rotate(path);
			path = rotate(path);
		}
		return path;
	}
	
	public int typeOfPath(Path path) { //returns an int that will be used to tell what tile image to use
		if(_top == false && _bottom == false && _left == true && _right == true) {
			return 0;//horizontal Straight
		}else if(_top == true && _bottom == true && _left == false && _right == false) {
			return 1;//vertical Straight
		}else if(_top == true && _bottom == false && _left == false && _right == true) {
			return 2;//top/right corner
		}else if(_top == false && _bottom == true && _left == false && _right == true) {
			return 3;//right/bottom corner
		}else if(_top == false && _bottom == true && _left == true && _right == false) {
			return 4;//bottom/left corner
		}else if(_top == true && _bottom == false && _left == true && _right == false) {
			return 5;//left/top corner
		}else if(_top == true && _bottom == false && _left == true && _right == true) {
			return 6;//Left/Top/Right Tee
		}else if(_top == true && _bottom == true && _left == false && _right == true) {
			return 7;//top/right/bottom Tee
		}else if(_top == false && _bottom == true && _left == true && _right == true) {
			return 8;//left/bottom/right Tee
		}else {
			return 9;//bottom/left/top Tee
		}

	}
}
