package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.Chesspiece;
import chess.Color;

public class Bishop extends Chesspiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// nw
		p.setValues(position.getRow() - 1, position.getColumns() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
			p.setValues(p.getRow() - 1, p.getColumns() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		// ne
		p.setValues(position.getRow() - 1, position.getColumns() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
			p.setValues(p.getRow() - 1, p.getColumns() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		// se
		p.setValues(position.getRow() + 1, position.getColumns() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
			p.setValues(p.getRow() + 1, p.getColumns() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		// sw
		p.setValues(position.getRow() + 1, position.getColumns() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
			p.setValues(p.getRow() + 1, p.getColumns() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		return mat;
	}
}