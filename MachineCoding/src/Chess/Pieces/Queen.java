package Chess.Pieces;

import Chess.Board;
import Chess.Color;

public class Queen extends Piece{
    public Queen(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int destRow, int destCol) {
        //TODO : Implement the logic
        return true;
    }
}