import java.util.ArrayList;

public class KingMovement {

    private ArrayList<PieceMovement> movementList;
    private int boardISize;
    private int boardJSize;
    private Piece piece;

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

    public ArrayList<PieceMovement> getMovementList() {
        return movementList;
    }
}
