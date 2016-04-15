package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

import Code.Tile.RealTile;
import board.Board;


public class ClockwiseEventHandler implements ActionListener{

private Board _b;
private RealTile _p;
public ClockwiseEventHandler(Board b, RealTile p){
	_b=b;
	_p=p;
	
}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		_p.setPath(_p.getPath().rotate(_p.getPath()));
	}

}
