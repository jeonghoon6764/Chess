import java.util.List;

public class testMain {

    public static void main(String[] args) {

        Board board = initialSetting();

        //printBoard(board);
        printBoardWithPath(board, 4, 4);
    }


    /**
     * PrintBoard method.
     * This will show you where the piece that located at [row][col] can go.
     * X = the place that selected piece can go
     * @param board board that want to print.
     */
    private static void printBoardWithPath(Board board, int row, int col) {

        MovementMaker mm = new MovementMaker(row, col, board);
        List<PieceMovement> movementList = mm.getMovementList();
        if(movementList.size() == 0) {
            System.out.println("wrong row col");
            return;
        }

        boolean[][] isPath = new boolean [board.getISize()][board.getJSize()];

        for (int n = 0; n < movementList.size(); n++) {
            isPath[movementList.get(n).getToI()][movementList.get(n).getToJ()] = true;
        }
        

        for (int i = 0; i < 8; i++) {
            System.out.println("+---+---+---+---+---+---+---+---+");
            for (int j = 0; j < 8; j++) {
                System.out.print("| ");
                String str = " ";
                if (isPath[i][j]) {
                    str = "X";
                } else if (board.getPiece(i, j) != null) {
                    str = board.getPiece(i, j).getMovementCode();
                }
                System.out.print(str + " ");
            }
            System.out.print("| \n");
        }
        System.out.println("+---+---+---+---+---+---+---+---+");
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

        //Usage: board.setPiece(row, col, "piece name", team number, "direction"(only for pawn));
        board.setPiece(0, 0, "rook", 0, "");
        board.setPiece(0, 1, "knight", 0, "");
        board.setPiece(0, 2, "bishop", 0, "");;
        board.setPiece(0, 3, "queen", 0, "");
        board.setPiece(0, 4, "king", 0, "");
        board.setPiece(0, 5, "bishop", 0, "");
        board.setPiece(0, 6, "knight", 0, "");;
        board.setPiece(0, 7, "rook", 0, "");

        board.setPiece(4, 4, "rook", 0, ""); //test purpose

        for (int i = 0; i < 8; i++) {
            board.setPiece(1, i, "pawn", 0, "down");
            board.setPiece(6, i, "pawn", 1, "up");
        }

        board.setPiece(7, 0, "rook", 1, "");
        board.setPiece(7, 1, "knight", 1, "");
        board.setPiece(7, 2, "bishop", 1, "");
        board.setPiece(7, 3, "queen", 1, "");
        board.setPiece(7, 4, "king", 1, "");
        board.setPiece(7, 5, "bishop", 1, "");
        board.setPiece(7, 6, "knight", 1, "");
        board.setPiece(7, 7, "rook", 1, "");

        return board;
    }

}
