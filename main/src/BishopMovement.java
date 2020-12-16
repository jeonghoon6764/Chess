import java.util.ArrayList;

public class BishopMovement {

    private ArrayList<PieceMovement> movementList;
    private int boardISize;
    private int boardJSize;
    private Piece piece;

    public BishopMovement(int i, int j, Board board) {

        movementList = new ArrayList<>();
        this.boardISize = board.getISize();
        this.boardJSize = board.getJSize();
        this.piece = board.getPiece(i, j);

        makeMovement(i, j, 1, 1, board);
        makeMovement(i, j, -1, 1, board);
        makeMovement(i, j, 1, -1, board);
        makeMovement(i, j, -1, -1, board);
    }


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

    public ArrayList<PieceMovement> getMovementList() {
        return movementList;
    }
}