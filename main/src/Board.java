import java.util.HashMap;
import java.util.Map;

/**
 * This is class that represents Board.
 * 
 * @version 1.0
 */
public class Board {

    private Piece [][] board;
    private int i;
    private int j;
    private Map<Integer, Double> scoreMap;

    /**
     * A constructor that take size i (row), size j (col)
     * @param i size of row.
     * @param j size of col.
     */
    public Board(int i, int j) {
        this.i = i;
        this.j = j;
        board = new Piece[i][j];
        scoreMap = new HashMap<>();
    }
    
    /**
     * Its role is to set the Piece at a specific location in the board array.
     * This will be used to set the initial piece position.
     * @param iIdx position of row.
     * @param jIdx position of col.
     * @param pieceName name of Piece.
     * @param teamNumber piece's team number.
     * @param pawnDirection pawn direction. The phone will move forward in a certain direction.
     */
    public void setPiece(int iIdx, int jIdx, String pieceName, int teamNumber, String pawnDirection) {
        if (iIdx >= i || jIdx >= j || iIdx < 0 || jIdx < 0) {
            System.out.println("idx setting is wrong. try again.");
        }
        board[iIdx][jIdx] = new Piece(pieceName, teamNumber, pawnDirection);
        ScoreCalculator sc = new ScoreCalculator(this);
        scoreMap = sc.getScoreMap();
    }

    /**
     * setter for piece
     * @param iIdx index of i
     * @param jIdx index of j
     * @param piece piece
     */
    public void setPiece(int iIdx, int jIdx, Piece piece) {
        board[iIdx][jIdx] = piece;
        ScoreCalculator sc = new ScoreCalculator(this);
        scoreMap = sc.getScoreMap();
    }

    /**
     * getter for piece.
     * @param i row index.
     * @param j col index.
     * @return piece object which is located on certain position.
     */
    public Piece getPiece(int i, int j) {
        return board[i][j];
    }

    /**
     * getter for row size.
     * @return row size.
     */
    public int getISize() {
        return i;
    }

    /**
     * getter for col size.
     * @return col size.
     */
    public int getJSize() {
        return j;
    }

    /**
     * getter for scoreMap.
     * @return scoreMap.
     */
    public Map<Integer, Double> getScoreMap() {
        return scoreMap;
    }

    /**
     * getter for score.
     * @param teamNumber teamNumber.
     * @return score of team.
     */
    public double getTeamScore(int teamNumber) {
        return scoreMap.get(teamNumber);
    }

    /**
     * This method takes a pieceMovement object and applies the contents of that object to the Board.
     * @param pieceMovement the movement of piece (object)
     */
    public Board applyMovement(PieceMovement pieceMovement) {
        int origI = pieceMovement.getFromI();
        int origJ = pieceMovement.getFromJ();
        int toI = pieceMovement.getToI();
        int toJ = pieceMovement.getToJ();

        Board newBoard = new Board(i, j);
        Piece piece = pieceMovement.getPiece();

        /*
        * Deep copying from current board to a new board. 
        */
        for(int count1 = 0; count1 < i; count1++){
            for(int count2 = 0; count2 < j; count2++){

                if (count1 == toI && count2 == toJ) {
                    newBoard.setPiece(count1, count2, piece);
                } else if (!(count1 == origI && count2 == origJ)) {
                    newBoard.setPiece(count1, count2, board[count1][count2]);
                }

            }
        }
        
        return newBoard;



        //board[origI][origJ] = null; //This code should be deleted later //It changes current board. Our current goal is to make a new board everytime we move a piece.
        //board[toI][toJ] = piece; //This code should be deleted later //It changes current board. Our current goal is to make a new board everytime we move a piece.
        //newBoard.board[toI][toJ] = piece; //Apply a new movement to a new board.
    }
}
