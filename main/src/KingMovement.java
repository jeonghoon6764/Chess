import java.util.ArrayList;

/**
 * King Movement Class. This class contains the information that the king needs to move.
 * @version 1.0
 */
public class KingMovement {

    private List<PieceMovement> movementList;
    private int boardISize;
    private int boardJSize;
    private Piece piece;

    /**
     * Constructor for KingMovement class.
     * @param i board index i which is king located.
     * @param j board index j which is king located.
     * @param board board
     */
    public KingMovement(int i, int j, Board board) {

        movementList = new ArrayList<>();
        this.boardISize = board.getISize();
        this.boardJSize = board.getJSize();
        this.piece = board.getPiece(i, j);

        makeMovement(i, j, 1, 0, board);
        makeMovement(i, j, -1, 0, board);
        makeMovement(i, j, 0, 1, board);
        makeMovement(i, j, 0, -1, board);
        makeMovement(i, j, 1, 1, board);
        makeMovement(i, j, -1, 1, board);
        makeMovement(i, j, 1, -1, board);
        makeMovement(i, j, -1, -1, board);
    }

    /**
     * This is helper method for making movements.
     * Returns a movement list that increases or decreases the toI, toJ variables by iIncrease
     * , jIncrease parameter size.
     * @param i i index of board, king currently located.
     * @param j j index of board, king currently located.
     * @param iIncrease i index increment.
     * @param jIncrease j index increment.
     * @param board board object.
     */
    public void makeMovement(int i, int j, int iIncrease, int jIncrease, Board board) {
        int origI = i;
        int origJ = j;


        i = i + iIncrease;
        j = j + jIncrease;
        if (i >= 0 && i < boardISize && j >= 0 && j < boardJSize
                && ((board.getPiece(i, j) == null) || (board.getPiece(i, j).getTeamNumber() != piece.getTeamNumber()))) {
            PieceMovement movement = new PieceMovement(origI, origJ, i, j, piece);
            movementList.add(movement);
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
