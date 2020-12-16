public class Piece {

    private String pieceName;
    private int numOfMove;
    private String movementCode;
    private int teamNumber;
    private boolean upPawn;
    private boolean downPawn;
    private boolean rightPawn;
    private boolean leftPawn;

    public Piece(String pieceName, int numOfMove, String movementCode
            , int teamNumber, String pawnDirection) {
        this.pieceName = pieceName;
        this.numOfMove = numOfMove;
        this.movementCode = movementCode;
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

    public Piece(String pieceName, int teamNumber, String pawnDirection) {
        this(pieceName, 0, "", teamNumber, pawnDirection);
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

    public Piece getQueeningPiece(String pieceName) {
        Piece queeningPiece;
        if (pieceName.equalsIgnoreCase("rook")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, "R", this.teamNumber
                    , "");
        } else if (pieceName.equalsIgnoreCase("knight")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, "Q", this.teamNumber
                    , "");
        } else if (pieceName.equalsIgnoreCase("bishop")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, "B", this.teamNumber
                    , "");
        } else if (pieceName.equalsIgnoreCase("queen")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, "Q", this.teamNumber
                    , "");
        } else if (pieceName.equalsIgnoreCase("King")) {
            queeningPiece = new Piece(
                    pieceName + " (" + this.pieceName + ")"
                    , this.numOfMove, "K", this.teamNumber
                    , "");
        } else {
            System.out.println("Something wrong in make piece.");
            queeningPiece = null;
        }

        return queeningPiece;
    }

    public void increamentNumOfMovement() {
        this.numOfMove++;
    }

    public String getPieceName() {
        return pieceName;
    }

    public int getNumOfMove() {
        return numOfMove;
    }

    public String getMovementCode() {
        return movementCode;
    }

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

    public int getTeamNumber() {
        return teamNumber;
    }
}
