import java.util.List;
import java.util.Scanner;

/**
 * This is class is only for test/practist purpose.
 * will remove this after GUI tool or JUnit Test is setted.
 * 
 * @version 1.0
 */
public class testMain {

    /**
     * Main method.
     * you can modify/add any code in here to test/practice code.
     * @param args parameter that from command.
     */
    public static void main(String[] args) {
        
        Board board = initialSetting(); // initial board set. see the method below.

        board.setPiece(4, 2, "Rook", 0, "");
        //printBoard(board); //printboard method. this will print current board status.
        printBoardWithPath(board, 4, 2); // printboard method. this will print current board with path.

        System.out.println("********** Current Score **********");
        System.out.println("Team 0 : " + board.getTeamScore(0));
        System.out.println("Team 1 : " + board.getTeamScore(1));
        //example of score usage.









        Scanner sc = new Scanner(System.in);

        int i = 0;
        String input = "";
        for (;;) {
            System.out.println("Fight 1 vs 1");
            if (i % 2 == 0) {
                System.out.println("\n\nwhich piece do you want to move?");
                input = sc.nextLine();
                System.out.println("\n\nto where?");
                input = sc.nextLine();

                printBoard(board);

            } else {
                System.out.println("\n\nwhich piece do you want to move?");
                input = sc.nextLine();
                System.out.println("\n\nto where?");
                input = sc.nextLine();

                printBoard(board);
                if (i == 19) {
                    break;
                }
            }


        }
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

        //board.setPiece(4, 4, "queen", 0, ""); //test purpose

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
