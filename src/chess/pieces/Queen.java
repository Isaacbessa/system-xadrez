package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.Chesspiece;
import chess.Color;

public class Queen extends Chesspiece {

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		// above
		p.setValues(position.getRow() - 1, position.getColumns());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
			p.setRow(p.getRow() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		// left
		p.setValues(position.getRow(), position.getColumns() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
			p.setColum(p.getColumns() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		// right
		p.setValues(position.getRow(), position.getColumns() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
			p.setColum(p.getColumns());
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		// below
		p.setValues(position.getRow() + 1, position.getColumns());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
			p.setRow(p.getRow() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumns()] = true;
		}
		
		// 
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