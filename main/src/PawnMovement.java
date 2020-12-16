import java.util.ArrayList;

public class PawnMovement {

    private ArrayList<PieceMovement> movementList;
    private int boardISize;
    private int boardJSize;
    private Piece piece;

    public PawnMovement(int i, int j, Board board) {

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
            System.out.println("pawnMovement method is wrong.");
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

    public ArrayList<PieceMovement> getMovementList() {
        return movementList;
    }
}
