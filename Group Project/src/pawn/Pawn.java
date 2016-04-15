package pawn;

public class Pawn {
	
	private static String _color;
	private int _x;
	private int _y;
	
	
	public Pawn(String s, int x, int y) {
		_color = s;
		_x = x;
		_y = y;
	}
	
	public String getColor() {
		return _color;
	}
	
	public int getX() {
		return _x;
	}
	public int getY() {
		return _y;
	}
}
