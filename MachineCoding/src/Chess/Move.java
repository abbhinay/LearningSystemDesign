package Chess;

import Chess.Pieces.Piece;

public class Move {
    private Piece piece;
    private int destRow;
    private int destCol;
    public Move(int destRow, int destCol, Piece piece) {
        this.destRow = destRow;
        this.destCol = destCol;
        this.piece = piece;
    }
    public int getDestRow() {
        return this.destRow;
    }
    public int getDestCol() {
        return this.destCol;
    }
    public Piece getPiece() {
        return this.piece;
    }
}
