package Chess.Pieces;

import Chess.Board;
import Chess.Color;

public class Bishop extends Piece{
    public Bishop(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int destRow, int destCol) {
        //TODO: Implement can move logic
        return true;
    }
}
