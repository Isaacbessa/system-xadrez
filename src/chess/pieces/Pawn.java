package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.Chesspiece;
import chess.Color;
//IMPLEMENTANDO AS PEÇAS (PAWN)


public class Pawn extends Chesspiece {

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumns());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumns()] = true;
			}
			p.setValues(position.getRow() - 2, position.getColumns());
			Position p2 = new Position(position.getRow() - 1, position.getColumns());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumns()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumns() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumns()] = true;
			}			
			p.setValues(position.getRow() - 1, position.getColumns() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumns()] = true;
			}	
			
			// #specialmove en passant white
			if (position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumns() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumns()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumns() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumns()] = true;
				}
			}
		}
		else {
			p.setValues(position.getRow() + 1, position.getColumns());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumns()] = true;
			}
			p.setValues(position.getRow() + 2, position.getColumns());
			Position p2 = new Position(position.getRow() + 1, position.getColumns());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumns()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumns() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumns()] = true;
			}			
			p.setValues(position.getRow() + 1, position.getColumns() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumns()] = true;
			}
			
			// #specialmove en passant black
			if (position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumns() - 1);
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumns()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumns() + 1);
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() + 1][right.getColumns()] = true;
				}
			}			
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}
	
}