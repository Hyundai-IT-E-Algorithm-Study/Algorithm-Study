import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        board = new int[9][9];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] row = reader.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }
        
        if (playGame(board)) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }


    public static boolean playGame(int[][] board) {
        int[] emptyLocation = emptyList(board);

        if (emptyLocation == null) {
            return true;
        }

        int row = emptyLocation[0];
        int col = emptyLocation[1];

        for (int num = 1; num <= 9; num++) {
            if (check(board, row, col, num)) {
                board[row][col] = num;

                if (playGame(board)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean check(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[] emptyList(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
