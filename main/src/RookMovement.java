import java.util.ArrayList;
import java.util.List;

/**
 * Rook Movement Class. This class contains the information that the rook needs to move.
 * @version 1.0
 */
public class RookMovement {

    private List<PieceMovement> movementList;
    private int boardISize;
    private int boardJSize;
    private Piece piece;

    /**
     * Constructor for RookMovement class.
     * @param i board index i which is rook located.
     * @param j board index j which is rook located.
     * @param board board
     */
    public RookMovement(int i, int j, Board board) {

        movementList = new ArrayList<>();
        this.boardISize = board.getISize();
        this.boardJSize = board.getJSize();
        this.piece = board.getPiece(i, j);

        makeMovement(i, j, 1, 0, board);
        makeMovement(i, j, -1, 0, board);
        makeMovement(i, j, 0, 1, board);
        makeMovement(i, j, 0, -1, board);
    }

    /**
     * This is helper method for making movements.
     * Returns a movement list that increases or decreases the toI, toJ variables by iIncrease
     * , jIncrease parameter size for each loop.
     * @param i i index of board, rook currently located.
     * @param j j index of board, rook currently located.
     * @param iIncrease i index increment.
     * @param jIncrease j index increment.
     * @param board board object.
     */
    private void makeMovement(int i, int j, int iIncrease, int jIncrease, Board board) {
        int origI = i;
        int origJ = j;

        i = i + iIncrease;
        j = j + jIncrease;

        while(i < boardISize && i >= 0 && j < boardJSize && j >= 0 && board.getPiece(i, j) == null) {
            PieceMovement pieceMovement = new PieceMovement(origI, origJ, i, j, piece);
            movementList.add(pieceMovement);
            i = i + iIncrease;
            j = j + jIncrease;
        }
        if (i < boardISize && i >= 0 && j < boardJSize && j >= 0
                && board.getPiece(i, j).getTeamNumber() != piece.getTeamNumber()) {
            PieceMovement pieceMovement = new PieceMovement(origI, origJ, i, j, piece);
            movementList.add(pieceMovement);
        }
    }

    /**
     * getter for movementList
     * @return movementList.
     */
    public List<PieceMovement> getMovementList() {
        return movementList;
    }
}