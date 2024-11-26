package Chess.Pieces;

import Chess.Board;
import Chess.Color;

public class Knight extends Piece{
    public Knight(int row, int col, Color color) {
        super(row, col, color);
    }

    @Override
    public boolean canMove(int destRow, int destCol) {
        //TODO : Implement the logic
        return true;
    }
}
