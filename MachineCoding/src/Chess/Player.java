package Chess;

import Chess.Pieces.Piece;

public class Player {
    private Color color;
    public Player(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return this.color;
    }
    public boolean makeMove(Move move) {
        Piece piece = move.getPiece();
        int destRow = move.getDestRow();
        int destCol = move.getDestCol();
        if(Board.getInstance().isValidMove(destRow, destCol, piece)) {
            int sourceRow = piece.getRow();
            int sourceCol = piece.getCol();
            Board.getInstance().setPiece(destRow, destCol, piece);
            Board.getInstance().setPiece(sourceRow, sourceCol, null);
            piece.setRow(destRow);
            piece.setCol(destCol);
            return true;
        } else {
            System.out.println("Please enter a valid move");
            return false;
        }
    }
}
