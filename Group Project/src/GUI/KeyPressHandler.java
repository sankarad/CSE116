package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import board.Board;

public class KeyPressHandler implements KeyListener{
	
private Board _boardModel;
	
	public KeyPressHandler(Board boardModel) {
		boardModel = _boardModel;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) { //use this one
		_boardModel.movePawn(e.getKeyCode());
		
	}

}
