import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int[][] sudoku = new int[9][9];
    static List<Point> pointList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int token = Integer.parseInt(st.nextToken());
                if (token == 0) pointList.add(new Point(i, j));
                sudoku[i][j] = token;
            }
        }

        dfs(0);

    }

    static void dfs(int index) throws IOException {
        if (index == pointList.size()) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        int x = pointList.get(index).x;
        int y = pointList.get(index).y;

        for (int i = 1; i <= 9; i++) {
            if (lineChecked(x, y, i) && boxChecked(x, y, i)) {
                sudoku[x][y] = i;
                dfs(index + 1);
                sudoku[x][y] = 0;
            }

        }
    }

    static boolean lineChecked(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value || sudoku[i][col] == value) return false;
        }
        return true;
    }

    static boolean boxChecked(int row, int col, int value) {
        int x = (row / 3) * 3;
        int y = (col / 3) * 3;

        for (int i = x; i < x + 3; i++) {
            for (int j =  y; j< y + 3; j++) {
                if (sudoku[i][j] == value) return false;
            }
        }
        return true;
    }
}
