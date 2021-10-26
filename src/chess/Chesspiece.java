
package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class Chesspiece extends Piece {

	private Color color;
	private int moveCount;

	public Chesspiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	protected void increaseMoveCount() {
		moveCount++;
	}

	protected void decreaseMoveCount() {
		moveCount--;
	}

	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		Chesspiece p = (Chesspiece)getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}