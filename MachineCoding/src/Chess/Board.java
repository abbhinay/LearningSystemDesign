package Chess;

import Chess.Pieces.*;

public class Board {
    private static volatile Board instance;
    private Piece[][] board;
    private Board() {
        this.board = new Piece[8][8];
        initializeBoard();
    }

    public static Board getInstance() {
        if(instance==null) {
            synchronized (Board.class)  {
                if(instance==null) {
                    instance = new Board();
                }
            }
        }
        return instance;
    }

    private void initializeBoard() {
        // Initialize white pieces
        board[0][0] = new Rook(0,0,Color.WHITE);
        board[0][1] = new Knight(0, 1,Color.WHITE);
        board[0][2] = new Bishop(0, 2,Color.WHITE);
        board[0][3] = new Queen( 0, 3,Color.WHITE);
        board[0][4] = new King(0, 4,Color.WHITE);
        board[0][5] = new Bishop(0, 5,Color.WHITE);
        board[0][6] = new Knight(0, 6,Color.WHITE);
        board[0][7] = new Rook(0, 7,Color.WHITE);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(1, i,Color.WHITE);
        }

        // Initialize black pieces
        board[7][0] = new Rook(7, 0,Color.BLACK);
        board[7][1] = new Knight(7, 1,Color.BLACK);
        board[7][2] = new Bishop(7, 2,Color.BLACK);
        board[7][3] = new Queen(7, 3,Color.BLACK);
        board[7][4] = new King(7, 4,Color.BLACK);
        board[7][5] = new Bishop(7, 5,Color.BLACK);
        board[7][6] = new Knight(7, 6,Color.BLACK);
        board[7][7] = new Rook(7, 7,Color.BLACK);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(6, i,Color.BLACK);
        }
    }
    public Piece getPiece(int row, int col) {
        return this.board[row][col];
    }
    public void setPiece(int row, int col, Piece piece) {
        this.board[row][col] = piece;
    }
    public boolean isValidMove(int row, int col, Piece piece) {
        if(piece==null || row<0 || col<0 || row>7 || col>7) return false;
        if(!piece.canMove(row, col)) return false;
        Piece dstPiece = board[row][col];
        if(dstPiece!=null && dstPiece.getColor()==piece.getColor()) return false;
        return true;
    }
    public boolean isCheckMate(Color color) {
        //TODO Implement the logic
        return true;
    }
    public boolean isStaleMate(Color color) {
        //TODO Implement the logic
        return true;
    }
    public void displayBoard() {
        //TODO Implement the logic
    }
}
