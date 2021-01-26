import java.util.HashMap;
import java.util.Map;

/**
 * Score Calculator class
 * @version 1.0
 */

public class ScoreCalculator {

    private Map<Integer, Double> scoreMap;

    private static final double ROOK_SCORE = 5;
    private static final double KNIGHT_SCORE = 3.25;
    private static final double BISHOP_SCORE = 3.35;
    private static final double QUEEN_SCORE = 9.75;
    private static final double KING_SCORE = 1000; // if king die --> lost.
    private static final double PAWN_SCORE = 1;

    /**
     * Constructor for ScoreCalculator Class.
     * No parm version.
     */
    public ScoreCalculator() {
        scoreMap = new HashMap<>();
    }

    public ScoreCalculator(Board board) {
        scoreMap = new HashMap<>();
        buildScore(board);
    }

    public void buildScore(Board board) {
        if (!scoreMap.isEmpty()) {
            scoreMap = new HashMap<>();
        }

        for (int i = 0; i < board.getISize(); i++) {
            for (int j = 0; j < board.getJSize(); j++) {
                Piece piece = board.getPiece(i, j);
                if (piece != null) {
                    int teamNumber = piece.getTeamNumber();
                    if (piece.getMovementCode().equalsIgnoreCase("P")) {
                        if(scoreMap.containsKey(teamNumber)) {
                            scoreMap.put(teamNumber, scoreMap.remove(teamNumber
                            ) + PAWN_SCORE);
                        } else {
                            scoreMap.put(teamNumber, PAWN_SCORE);
                        }
                    } else if (piece.getMovementCode().equalsIgnoreCase("R")) {
                        if(scoreMap.containsKey(teamNumber)) {
                            scoreMap.put(teamNumber, scoreMap.remove(teamNumber
                            ) + ROOK_SCORE);
                        } else {
                            scoreMap.put(teamNumber, ROOK_SCORE);
                        }
                    } else if (piece.getMovementCode().equalsIgnoreCase("N")) {
                        if(scoreMap.containsKey(teamNumber)) {
                            scoreMap.put(teamNumber, scoreMap.remove(teamNumber
                            ) + KNIGHT_SCORE);
                        } else {
                            scoreMap.put(teamNumber, KNIGHT_SCORE);
                        }
                    } else if (piece.getMovementCode().equalsIgnoreCase("B")) {
                        if(scoreMap.containsKey(teamNumber)) {
                            scoreMap.put(teamNumber, scoreMap.remove(teamNumber
                            ) + BISHOP_SCORE);
                        } else {
                            scoreMap.put(teamNumber, BISHOP_SCORE);
                        }
                    } else if (piece.getMovementCode().equalsIgnoreCase("Q")) {
                        if(scoreMap.containsKey(teamNumber)) {
                            scoreMap.put(teamNumber, scoreMap.remove(teamNumber
                            ) + QUEEN_SCORE);
                        } else {
                            scoreMap.put(teamNumber, QUEEN_SCORE);
                        }
                    } else if (piece.getMovementCode().equalsIgnoreCase("K")) {
                        if(scoreMap.containsKey(teamNumber)) {
                            scoreMap.put(teamNumber, scoreMap.remove(teamNumber
                            ) + KING_SCORE);
                        } else {
                            scoreMap.put(teamNumber, KING_SCORE);
                        }
                    }
                }
            }
        }
    }

    public Map<Integer, Double> getScoreMap() {
        return scoreMap;
    }
}
