import java.util.ArrayList;
import java.util.List;

public class testMain {

    public static void main(String[] args) {

        Board board = initialSetting();
        printBoard(board);

        RookMovement rm = new RookMovement(4, 4, board);
        List<PieceMovement> list = rm.getMovementList();

        System.out.println("index [4][4] rook can go to ... \n");

        for (int i = 0; i < list.size(); i++) {
            int testi = list.get(i).getToI();
            int testj = list.get(i).getToJ();

            System.out.println("i value : " + testi + " j value : " + testj +"\n");
        }


    }

    /**
     * PrintBoard method.
     * @param board board that want to print.
     */
    private static void printBoard(Board board) {
        for (int i = 0; i < 8; i++) {
            System.out.println("+---+---+---+---+---+---+---+---+");
            for (int j = 0; j < 8; j++) {
                System.out.print("| ");
                String str = " ";
                if (board.getPiece(i, j) != null) {
                    str = board.getPiece(i, j).getMovementCode();
                }
                System.out.print(str + " ");
            }
            System.out.print("| \n");
        }
        System.out.println("+---+---+---+---+---+---+---+---+");
    }

    /**
     * initial setting
     * @return initial board
     */
    private static Board initialSetting() {
        Board board = new Board(8, 8);

        board.setPiece(0, 0, "rook", 0, "down");
        board.setPiece(0, 1, "knight", 0, "down");
        board.setPiece(0, 2, "bishop", 0, "down");
        board.setPiece(0, 3, "queen", 0, "down");
        board.setPiece(0, 4, "king", 0, "down");
        board.setPiece(0, 5, "bishop", 0, "down");
        board.setPiece(0, 6, "knight", 0, "down");
        board.setPiece(0, 7, "rook", 0, "down");

        board.setPiece(4, 4, "rook", 0, "down"); //test purpose

        for (int i = 0; i < 8; i++) {
            board.setPiece(1, i, "pawn", 0, "down");
            board.setPiece(6, i, "pawn", 1, "up");
        }

        board.setPiece(7, 0, "rook", 1, "up");
        board.setPiece(7, 1, "knight", 1, "up");
        board.setPiece(7, 2, "bishop", 1, "up");
        board.setPiece(7, 3, "queen", 1, "up");
        board.setPiece(7, 4, "king", 1, "up");
        board.setPiece(7, 5, "bishop", 1, "up");
        board.setPiece(7, 6, "knight", 1, "up");
        board.setPiece(7, 7, "rook", 1, "up");

        return board;
    }

}
