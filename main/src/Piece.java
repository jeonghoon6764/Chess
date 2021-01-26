/**
 * This is class that represents Piece.
 * @version 1.0
 */
public class Piece {

    private String pieceName;
    private int numOfMove; //number of movement. (for special rules, such as En Passant, Castling)
    private String movementCode; //represent movement. (P = Pawn, R = Rook, N = Knight, B = bishop, Q = Queen, K = King)
    private int teamNumber; //represent teamNumber (for 1vs1vs1vs1)
    private boolean upPawn; //direction of pawn (only for pawn object, else -> false all)
    private boolean downPawn;
    private boolean rightPawn;
    private boolean leftPawn;

    /**
     * Constructor for Piece.
     * @param pieceName name of Piece (e.g pawn, rook, knight, etc)
     * @param numOfMove number of movement (see above)
     * @param movementCode movementCode (see above) 
     * @param teamNumber represent teamNumber (see above) 
     * @param pawnDirection direction of pawn (see above)
     */
    public Piece(String pieceName, int numOfMove, int teamNumber, String pawnDirection) {
        this.pieceName = pieceName;
        this.numOfMove = numOfMove;
        this.movementCode = "";
        this.teamNumber = teamNumber;
        this.upPawn = false;
        this.downPawn = false;
        this.rightPawn = false;
        this.leftPawn = false;
        if (pawnDirection.equalsIgnoreCase("up")) {
            this.upPawn = true;
        } else if (pawnDirection.equalsIgnoreCase("down")) {
            this.downPawn = true;
        } else if (pawnDirection.equalsIgnoreCase("right")) {
            this.rightPawn = true;
        } else if (pawnDirection.equalsIgnoreCase("left")) {
            this.leftPawn = true;
        }
    }

    /**
     * Constructor for Piece (we mostly use)
     * @param pieceName name of Piece (e.g pawn, rook, knight, etc)
     * @param teamNumber represent teamNumber (see above)
     * @param pawnDirection direction of pawn (see above)
     */
    public Piece(String pieceName, int teamNumber, String pawnDirection) {
        this(pieceName, 0, teamNumber, pawnDirection);
        if (pieceName.equalsIgnoreCase("pawn")) {
            movementCode = "P";
        } else if (pieceName.equalsIgnoreCase("rook")) {
            movementCode = "R";
        } else if (pieceName.equalsIgnoreCase("knight")) {
            movementCode = "N";
        } else if (pieceName.equalsIgnoreCase("bishop")) {
            movementCode = "B";
        } else if (pieceName.equalsIgnoreCase("queen")) {
            movementCode = "Q";
        } else if (pieceName.equalsIgnoreCase("King")) {
            movementCode = "K";
        } else {
            System.out.println("Something wrong in make piece.");
        }
    }

    /**
     * This method is designed to implement queening.
     * @param pieceName The piece that the pawn will change to
     * @return new Piece
     */
    public Piece getQueeningPiece(String pieceName) {
        Piece queeningPiece;
        if (pieceName.equalsIgnoreCase("rook")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, this.teamNumber
                    , "");
        } else if (pieceName.equalsIgnoreCase("knight")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, this.teamNumber
                    , "");
        } else if (pieceName.equalsIgnoreCase("bishop")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, this.teamNumber
                    , "");
        } else if (pieceName.equalsIgnoreCase("queen")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, this.teamNumber
                    , "");
        } else if (pieceName.equalsIgnoreCase("King")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, this.teamNumber
                    , "");
        } else {
            System.out.println("Something wrong in make piece.");
            queeningPiece = null;
        }

        return queeningPiece;
    }

    /**
     * This method will increase the numberOfMovement.
     */
    public void increamentNumOfMovement() {
        this.numOfMove++;
    }

    /**
     * getter for pieceName
     * @return pieceName
     */
    public String getPieceName() {
        return pieceName;
    }

    /**
     * getter for NumOfMove
     * @return NumOfMove
     */
    public int getNumOfMove() {
        return numOfMove;
    }

    /**
     * getter for movementCode
     * @return movementCode
     */
    public String getMovementCode() {
        return movementCode;
    }

    /**
     * getter for pawnDirection
     * @return pawnDirection
     */
    public String getPawnDirection() {
        if (upPawn) {
            return "up";
        } else if (downPawn) {
            return "down";
        } else if (rightPawn) {
            return "right";
        } else if (leftPawn) {
            return "left";
        } else {
            return "";
        }
    }

    /**
     * getter for TeamNumber
     * @return teamNumber
     */
    public int getTeamNumber() {
        return teamNumber;
    }
}
