public class Board {

    private Piece [][] board;
    private int i;
    private int j;

    public Board(int i, int j) {
        this.i = i;
        this.j = j;
        board = new Piece[i][j];

        /*
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                board[m][n] = null;
            }
        }
         */
    }

    public void setPiece(int iIdx, int jIdx, String pieceName, int teamNumber, String pawnDirection) {
        if (iIdx >= i || jIdx >= j || iIdx < 0 || jIdx < 0) {
            System.out.println("idx setting is wrong. try again.");
        }
        board[iIdx][jIdx] = new Piece(pieceName, teamNumber, pawnDirection);
    }

    public Piece getPiece(int i, int j) {
        return board[i][j];
    }

    public int getISize() {
        return i;
    }

    public int getJSize() {
        return j;
    }

    public void applyMovement(PieceMovement pieceMovement) {
        int origI = pieceMovement.getFromI();
        int origJ = pieceMovement.getFromJ();

        int i = pieceMovement.getToI();
        int j = pieceMovement.getToJ();

        Piece piece = pieceMovement.getPiece();

        board[origI][origJ] = null;
        board[i][j] = piece;
    }



}
