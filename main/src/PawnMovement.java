import java.util.ArrayList;
import java.util.List;
/**
 * Pawn Movement Class. This class contains the information that the pawn needs to move.
 * @version 1.0
 */
public class PawnMovement {

    private List<PieceMovement> movementList;
    private int boardISize;
    private int boardJSize;
    private Piece piece;

    /**
     * Constructor for PawnMovement class.
     * 
     * @param i     board index i which is pawn located.
     * @param j     board index j which is pawn located.
     * @param board board
     */
    public PawnMovement(int i, int j, Board board){

        movementList = new ArrayList<>();
        this.boardISize = board.getISize();
        this.boardJSize = board.getJSize();

        this.piece = board.getPiece(i, j);

        if (piece.getPawnDirection().equalsIgnoreCase("down")) {
            pawnDirectionDown(i, j, board);
        } else if (piece.getPawnDirection().equalsIgnoreCase("up")) {
            pawnDirectionUp(i, j, board);
        } else if (piece.getPawnDirection().equalsIgnoreCase("right")) {
            pawnDirectionRight(i, j, board);
        } else if (piece.getPawnDirection().equalsIgnoreCase("left")) {
            pawnDirectionLeft(i, j, board);
        } else {
            //throw new Exception("pawnMovement method is wrong.");
        }

        int listSize = movementList.size();
        for (int k = 0; k < listSize; k++) {
            PieceMovement queeningMovement = movementList.get(k);

            if (queeningMovement.getPiece().getPawnDirection().equalsIgnoreCase("right")
                && queeningMovement.getToJ() == boardJSize - 1) {
                movementList.remove(k);
                movementList.addAll(queeningMovement.getQueeningMovement());
            } else if (queeningMovement.getPiece().getPawnDirection().equalsIgnoreCase("left")
                    && queeningMovement.getToJ() == 0) {
                movementList.remove(k);
                movementList.addAll(queeningMovement.getQueeningMovement());
            } else if (queeningMovement.getPiece().getPawnDirection().equalsIgnoreCase("up")
                    && queeningMovement.getToI() == 0) {
                movementList.remove(k);
                movementList.addAll(queeningMovement.getQueeningMovement());
            } else if (queeningMovement.getPiece().getPawnDirection().equalsIgnoreCase("down")
                    && queeningMovement.getToI() == boardISize - 1) {
                movementList.remove(k);
                movementList.addAll(queeningMovement.getQueeningMovement());
            }
        }
    }


    /**
     * This is the setter method for pawn movement, which is going down.
     * @param i i index of board, pawn currently located.
     * @param j j index of board, pawn currently located.
     * @param board board object.
     */
    private void pawnDirectionDown(int i, int j, Board board) {
        if (piece.getNumOfMove() == 0) {
            if (i + 1 < boardISize && i + 1 >= 0
                    && j < boardJSize && j >= 0
                    && board.getPiece(i + 1, j) == null) {

                PieceMovement movmnt = new PieceMovement(i, j, i + 1, j, piece);
                movementList.add(movmnt);

                if (i + 2 < boardISize && i + 2 >= 0
                        && j < boardJSize && j >= 0
                        && board.getPiece(i + 2, j) == null) {

                    PieceMovement movmnt2 = new PieceMovement(i, j, i + 2, j, piece);
                    movementList.add(movmnt2);

                }
            }
        } else {
            if (i + 1 < boardISize && i + 1 >= 0
                    && j < boardJSize && j >= 0
                    && board.getPiece(i + 1, j) == null) {

                PieceMovement movmnt = new PieceMovement(i, j, i + 1, j, piece);
                movementList.add(movmnt);
            }
        }

        if (i + 1 < boardISize && i + 1 >= 0
                && j - 1 < boardJSize && j - 1 >= 0
                && board.getPiece(i + 1, j - 1) != null
                && board.getPiece(i + 1, j - 1).getTeamNumber() != piece.getTeamNumber()) {

            PieceMovement movmnt = new PieceMovement(i, j, i + 1, j - 1, piece);
            movementList.add(movmnt);

        }

        if (i + 1 < boardISize && i + 1 >= 0
                && j + 1 < boardJSize && j + 1 >= 0
                && board.getPiece(i + 1, j + 1) != null
                && board.getPiece(i + 1, j + 1).getTeamNumber() != piece.getTeamNumber()) {

            PieceMovement movmnt = new PieceMovement(i, j, i + 1, j + 1, piece);
            movementList.add(movmnt);

        }
    }

    /**
     * This is the setter method for pawn movement, which is going up.
     * @param i i index of board, pawn currently located.
     * @param j j index of board, pawn currently located.
     * @param board board object.
     */
    private void pawnDirectionUp(int i, int j, Board board) {
        if (piece.getNumOfMove() == 0) {
            if (i - 1 < boardISize && i - 1 >= 0
                    && j < boardJSize && j >= 0
                    && board.getPiece(i - 1, j) == null) {

                PieceMovement movmnt = new PieceMovement(i, j, i - 1, j, piece);
                movementList.add(movmnt);

                if (i - 2 < boardISize && i - 2 >= 0
                        && j < boardJSize && j >= 0
                        && board.getPiece(i - 2, j) == null) {

                    PieceMovement movmnt2 = new PieceMovement(i, j, i - 2, j, piece);
                    movementList.add(movmnt2);

                }
            }
        } else {
            if (i - 1 < boardISize && i - 1 >= 0
                    && j < boardJSize && j >= 0
                    && board.getPiece(i - 1, j) == null) {

                PieceMovement movmnt = new PieceMovement(i, j, i - 1, j, piece);
                movementList.add(movmnt);
            }
        }

        if (i - 1 < boardISize && i - 1 >= 0
                && j - 1 < boardJSize && j - 1 >= 0
                && board.getPiece(i - 1, j - 1) != null
                && board.getPiece(i - 1, j - 1).getTeamNumber() != piece.getTeamNumber()) {

            PieceMovement movmnt = new PieceMovement(i, j, i - 1, j - 1, piece);
            movementList.add(movmnt);

        }

        if (i - 1 < boardISize && i - 1 >= 0
                && j + 1 < boardJSize && j + 1 >= 0
                && board.getPiece(i - 1, j + 1) != null
                && board.getPiece(i - 1, j + 1).getTeamNumber() != piece.getTeamNumber()) {

            PieceMovement movmnt = new PieceMovement(i, j, i - 1, j + 1, piece);
            movementList.add(movmnt);

        }
    }

    /**
     * This is the setter method for pawn movement, which is going right.
     * @param i i index of board, pawn currently located.
     * @param j j index of board, pawn currently located.
     * @param board board object.
     */
    private void pawnDirectionRight(int i, int j, Board board) {
        if (piece.getNumOfMove() == 0) {
            if (i < boardISize && i >= 0
                    && j + 1 < boardJSize && j + 1 >= 0
                    && board.getPiece(i, j + 1) == null) {

                PieceMovement movmnt = new PieceMovement(i, j, i, j + 1, piece);
                movementList.add(movmnt);

                if (i < boardISize && i >= 0
                        && j + 2 < boardJSize && j + 2 >= 0
                        && board.getPiece(i, j + 2) == null) {

                    PieceMovement movmnt2 = new PieceMovement(i, j, i, j + 2, piece);
                    movementList.add(movmnt2);

                }
            }
        } else {
            if (i < boardISize && i >= 0
                    && j + 1 < boardJSize && j + 1 >= 0
                    && board.getPiece(i, j + 1) == null) {

                PieceMovement movmnt = new PieceMovement(i, j, i, j + 1, piece);
                movementList.add(movmnt);
            }
        }

        if (i - 1 < boardISize && i - 1 >= 0
                && j + 1 < boardJSize && j + 1 >= 0
                && board.getPiece(i - 1, j + 1) != null
                && board.getPiece(i - 1, j + 1).getTeamNumber() != piece.getTeamNumber()) {

            PieceMovement movmnt = new PieceMovement(i, j, i - 1, j + 1, piece);
            movementList.add(movmnt);

        }

        if (i + 1 < boardISize && i + 1 >= 0
                && j + 1 < boardJSize && j + 1 >= 0
                && board.getPiece(i + 1, j + 1) != null
                && board.getPiece(i + 1, j + 1).getTeamNumber() != piece.getTeamNumber()) {

            PieceMovement movmnt = new PieceMovement(i, j, i + 1, j + 1, piece);
            movementList.add(movmnt);

        }
    }


    /**
     * This is the setter method for pawn movement, which is going left.
     * @param i i index of board, pawn currently located.
     * @param j j index of board, pawn currently located.
     * @param board board object.
     */
    private void pawnDirectionLeft(int i, int j, Board board) {
        if (piece.getNumOfMove() == 0) {
            if (i < boardISize && i >= 0
                    && j - 1 < boardJSize && j - 1 >= 0
                    && board.getPiece(i, j - 1) == null) {

                PieceMovement movmnt = new PieceMovement(i, j, i, j - 1, piece);
                movementList.add(movmnt);

                if (i < boardISize && i >= 0
                        && j - 2 < boardJSize && j - 2 >= 0
                        && board.getPiece(i, j - 2) == null) {

                    PieceMovement movmnt2 = new PieceMovement(i, j, i, j - 2, piece);
                    movementList.add(movmnt2);

                }
            }
        } else {
            if (i < boardISize && i >= 0
                    && j - 1 < boardJSize && j - 1 >= 0
                    && board.getPiece(i, j - 1) == null) {

                PieceMovement movmnt = new PieceMovement(i, j, i, j - 1, piece);
                movementList.add(movmnt);
            }
        }

        if (i - 1 < boardISize && i - 1 >= 0
                && j - 1 < boardJSize && j - 1 >= 0
                && board.getPiece(i - 1, j - 1) != null
                && board.getPiece(i - 1, j - 1).getTeamNumber() != piece.getTeamNumber()) {

            PieceMovement movmnt = new PieceMovement(i, j, i - 1, j - 1, piece);
            movementList.add(movmnt);

        }

        if (i + 1 < boardISize && i + 1 >= 0
                && j - 1 < boardJSize && j - 1 >= 0
                && board.getPiece(i + 1, j - 1) != null
                && board.getPiece(i + 1, j - 1).getTeamNumber() != piece.getTeamNumber()) {

            PieceMovement movmnt = new PieceMovement(i, j, i + 1, j - 1, piece);
            movementList.add(movmnt);

        }
    }

    /**
     * getter method for movementList
     * @return list of movement.
     */
    public List<PieceMovement> getMovementList() {
        return movementList;
    }
}
