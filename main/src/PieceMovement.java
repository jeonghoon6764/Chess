import java.util.ArrayList;

public class PieceMovement {

    private int fromI;
    private int fromJ;
    private int toI;
    private int toJ;
    private Piece piece;

    public PieceMovement(int fromI, int fromJ, int toI, int toJ, Piece piece) {
        this.fromI = fromI;
        this.fromJ = fromJ;
        this.toI = toI;
        this.toJ = toJ;
        this.piece = piece;
    }

    public ArrayList<PieceMovement> getQueeningMovement() {
        Piece cloneRookPiece = piece.getQueeningPiece("rook");
        Piece cloneKnightPiece = piece.getQueeningPiece("knight");
        Piece cloneBishopPiece = piece.getQueeningPiece("bishop");
        Piece cloneQueenPiece = piece.getQueeningPiece("queen");
        PieceMovement rookMovement = new PieceMovement(fromI, fromJ, toI, toJ, cloneRookPiece);
        PieceMovement knightMovement = new PieceMovement(fromI, fromJ, toI, toJ, cloneKnightPiece);
        PieceMovement bishopMovement = new PieceMovement(fromI, fromJ, toI, toJ, cloneBishopPiece);
        PieceMovement queenMovement = new PieceMovement(fromI, fromJ, toI, toJ, cloneQueenPiece);

        ArrayList<PieceMovement> list = new ArrayList<>();

        list.add(rookMovement);
        list.add(knightMovement);
        list.add(bishopMovement);
        list.add(queenMovement);

        return list;
    }

    public int getFromI() { return fromI; }

    public int getFromJ() { return fromJ; }

    public int getToI() {
        return toI;
    }

    public int getToJ() {
        return toJ;
    }


    public Piece getPiece() {
        return piece;
    }
}
