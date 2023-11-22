class Solution {
    static int answer = 0;
    static boolean[] visitedColumn;
    static int[][] visitedDiagonal;
    public int solution(int n) {
        int tmp = 0;

        for (int k = 0; k < (n % 2 == 0 ? n / 2 : n / 2 + 1); k++) {
            visitedColumn = new boolean[n];
            visitedDiagonal = new int[n][n];
            visitedColumn[k] = true;
            changeVisited(0, k,n);
            backtracking(0, n - 1,n);
            if (n % 2 == 1 && k == n / 2 - 1) {
                tmp = answer;
            }

        }

        if (n % 2 == 0) {
            return 2 * answer;
        } else {
            return answer + tmp;
        }
    }

    static void backtracking(int row, int queen, int n) {
        if (queen == 0) {
            answer++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if (visitedColumn[j]) {
                continue;
            } else if (visitedDiagonal[row + 1][j] > 0) {
                continue;
            }
            visitedColumn[j] = true;
            changeVisited(row + 1, j, n);
            backtracking(row + 1, queen - 1, n);
            visitedColumn[j] = false;
            changeNotVisited(row + 1, j, n);
        }
    }

    static void changeVisited(int y, int x, int n) {
        for (int i = 1; i < n; i++) {
            if (0 <= y + i && y + i < n && 0 <= x + i && x + i < n) {
                visitedDiagonal[y + i][x + i]++;
            }
            if (0 <= y - i && y - i < n && 0 <= x - i && x - i < n) {
                visitedDiagonal[y - i][x - i]++;
            }
            if (0 <= y - i && y - i < n && 0 <= x + i && x + i < n) {
                visitedDiagonal[y - i][x + i]++;
            }
            if (0 <= y + i && y + i < n && 0 <= x - i && x - i < n) {
                visitedDiagonal[y + i][x - i]++;
            }
        }
        visitedDiagonal[y][x]++;
    }

    static void changeNotVisited(int y, int x, int n) {
        for (int i = 1; i < n; i++) {
            if (0 <= y + i && y + i < n && 0 <= x + i && x + i < n) {
                visitedDiagonal[y + i][x + i]--;
            }
            if (0 <= y - i && y - i < n && 0 <= x - i && x - i < n) {
                visitedDiagonal[y - i][x - i]--;
            }
            if (0 <= y - i && y - i < n && 0 <= x + i && x + i < n) {
                visitedDiagonal[y - i][x + i]--;
            }
            if (0 <= y + i && y + i < n && 0 <= x - i && x - i < n) {
                visitedDiagonal[y + i][x - i]--;
            }
        }
        visitedDiagonal[y][x]--;
    }
}
