public class scoreCalculator {

    private double currentScore;
    private int teamNumber;
    private int boardISize;
    private int boardJSize;

    private static final double ROOK_SCORE = 5;
    private static final double KNIGHT_SCORE = 3.25;
    private static final double BISHOP_SCORE = 3.35;
    private static final double QUEEN_SCORE = 9.75;
    private static final double KING_SCORE = 1000;
    private static final double PAWN_SCORE = 1;

    public scoreCalculator(int teamNumber, Board board) {
        currentScore = 0;
        this.teamNumber = teamNumber;
        this.boardISize = board.getISize();
        this.boardJSize = board.getJSize();

        buildScore(teamNumber, board);
    }

    public void buildScore(int teamNumber, Board board) {

        for (int i = 0; i < boardISize; i++) {
            for (int j = 0; j < boardJSize; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece != null) {
                    if (piece.getTeamNumber() == teamNumber) {
                        if (piece.getMovementCode().equalsIgnoreCase("P")) {
                            currentScore += PAWN_SCORE;
                        } else if (piece.getMovementCode().equalsIgnoreCase("R")) {
                            currentScore += ROOK_SCORE;
                        } else if (piece.getMovementCode().equalsIgnoreCase("N")) {
                            currentScore += KNIGHT_SCORE;
                        } else if (piece.getMovementCode().equalsIgnoreCase("B")) {
                            currentScore += BISHOP_SCORE;
                        } else if (piece.getMovementCode().equalsIgnoreCase("Q")) {
                            currentScore += QUEEN_SCORE;
                        } else if (piece.getMovementCode().equalsIgnoreCase("K")) {
                            currentScore += KING_SCORE;
                        }
                    }
                }
            }
        }
    }

    public double getScore() {
        return currentScore;
    }
}
