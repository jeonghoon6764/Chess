import java.util.ArrayList;
import java.util.List;
/**
 * Piece Movement Class. This object contains the information that each Piece needs to move.
 * @version 1.0
 */
public class PieceMovement {

    private int fromI;
    private int fromJ;
    private int toI;
    private int toJ;
    private Piece piece;

    /**
     * Constructor. It has values that each Piece needs to move.
     * @param fromI I index number (currently located)
     * @param fromJ J index number (currently located)
     * @param toI I index number (will be located)
     * @param toJ J index number (will be located)
     * @param piece piece Object
     */
    public PieceMovement(int fromI, int fromJ, int toI, int toJ, Piece piece) {
        this.fromI = fromI;
        this.fromJ = fromJ;
        this.toI = toI;
        this.toJ = toJ;
        this.piece = piece;
    }

    /**
     * This is a method for implementing the Queening of Pawn objects.
     * By calling this method, the movements will be returned which Queening has occurred.
     * @return Queening movement objects list
     */
    public List<PieceMovement> getQueeningMovement() {
        Piece cloneRookPiece = piece.getQueeningPiece("rook");
        Piece cloneKnightPiece = piece.getQueeningPiece("knight");
        Piece cloneBishopPiece = piece.getQueeningPiece("bishop");
        Piece cloneQueenPiece = piece.getQueeningPiece("queen");
        PieceMovement rookMovement = new PieceMovement(fromI, fromJ, toI, toJ, cloneRookPiece);
        PieceMovement knightMovement = new PieceMovement(fromI, fromJ, toI, toJ, cloneKnightPiece);
        PieceMovement bishopMovement = new PieceMovement(fromI, fromJ, toI, toJ, cloneBishopPiece);
        PieceMovement queenMovement = new PieceMovement(fromI, fromJ, toI, toJ, cloneQueenPiece);

        List<PieceMovement> list = new ArrayList<>();

        list.add(rookMovement);
        list.add(knightMovement);
        list.add(bishopMovement);
        list.add(queenMovement);

        return list;
    }

    /**
     * getter method for fromI.
     * @return fromI
     */
    public int getFromI() { return fromI; }

    /**
     * getter method for FromJ.
     * @return fromJ
     */
    public int getFromJ() { return fromJ; }

    /**
     * getter method for toI.
     * @return toI
     */
    public int getToI() {
        return toI;
    }

    /**
     * getter method for toJ.
     * @return toJ
     */
    public int getToJ() {
        return toJ;
    }

    /**
     * getter method for piece.
     * @return piece
     */
    public Piece getPiece() {
        return piece;
    }
}
