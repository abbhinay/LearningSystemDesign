package Chess.Pieces;

import Chess.Board;
import Chess.Color;

public abstract class Piece {
    protected int row;
    protected int col;
    protected final Color color;
    public Piece(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }
    public abstract boolean canMove(int destRow, int destCol);
    public int getRow() {
        return this.row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return this.col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public Color getColor() {
        return this.color;
    }
}
