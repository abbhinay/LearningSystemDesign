package Chess;

import Chess.Pieces.Piece;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessGame {
    private final Board board;
    private final Player[] players;
    private int currentPlayer;
    public ChessGame() {
        board = Board.getInstance();
        players = new Player[]{new Player(Color.WHITE), new Player(Color.BLACK)};
        currentPlayer = 0;
    }
    public void start() throws IOException {
        System.out.println("Enter source row, source col, destination row, destination col");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!isGameOver()) {
            Player player = players[currentPlayer];
            System.out.println(player.getColor() + "'s turn.");
            board.displayBoard();

            String[] input = br.readLine().split(" ");
            if(input.length!=4) {
                System.out.println("Wrong input");
                continue;
            }

            int srcRow = Integer.parseInt(input[0]);
            int srcCol = Integer.parseInt(input[1]);
            int dstRow = Integer.parseInt(input[2]);
            int dstCol = Integer.parseInt(input[3]);

            Piece piece = board.getPiece(srcRow, srcCol);
            Move move = new Move(dstRow, dstCol, piece);

            if(!player.makeMove(move)) {
                System.out.println("Illegel Move");
                continue;
            }

            currentPlayer = currentPlayer==0 ? 1 : 0;
        }
        displayResult();
    }
    private boolean isGameOver() {
        return board.isCheckMate(players[0].getColor()) || board.isCheckMate(players[1].getColor())
                || board.isStaleMate(players[0].getColor()) || board.isStaleMate(players[1].getColor());
    }
    private void displayResult() {
        if(board.isCheckMate(players[0].getColor())) {
            System.out.println("Black wins by checkmate!");
        } else if(board.isCheckMate(players[1].getColor())) {
            System.out.println("White wins by checkmate!");
        } else if(board.isStaleMate(players[0].getColor()) || board.isStaleMate(players[1].getColor())) {
            System.out.println("The game ends in a stalemate!");
        }
    }
}
