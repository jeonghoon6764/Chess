import java.util.ArrayList;
import java.util.List;

public class MovementMaker {
    private int i;
    private int j;
    private Board board;

    private List<PieceMovement> movementList;

    public MovementMaker(int i, int j, Board board) {
        this.i = i;
        this.j = j;
        this.board = board;

        movementList = makeMovement(i, j, board);
    }

    private List<PieceMovement> makeMovement(int i, int j, Board board) {
        List<PieceMovement> retList;

        Piece piece = board.getPiece(i, j);
        String code = piece.getMovementCode();

        if (code.equals("P")) {
            PawnMovement pm = new PawnMovement(i, j, board);
            retList = pm.getMovementList();
        } else if (code.equals("R")) {
            RookMovement rm = new RookMovement(i, j, board);
            retList = rm.getMovementList();
        } else if (code.equals("N")) {
            KnightMovement nm = new KnightMovement(i, j, board);
            retList = nm.getMovementList();
        } else if (code.equals("B")) {
            BishopMovement bm = new BishopMovement(i, j, board);
            retList = bm.getMovementList();
        } else if (code.equals("Q")) {
            QueenMovement qm = new QueenMovement(i, j, board);
            retList = qm.getMovementList();
        } else if (code.equals("K")) {
            KingMovement km = new KingMovement(i, j, board);
            retList = km.getMovementList();
        } else {
            retList = new ArrayList<>();
        }

        return retList;
    }

    public List<PieceMovement> getMovementList() {
        return movementList;
    }
}
