import java.util.Scanner;

public class Main {

    static int[][] arr = new int[9][9];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 스도쿠 구조 저장
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        // 스도쿠 함수 초기화
        sudoku(0, 0);
    }
    
    // 스도쿠 구조 채우기
    public static void sudoku(int row, int col) {
        // 특정 행이 다 채워졌으면 다음 행의 첫 번째 열부터 시작
        if(col == 9) {
            sudoku(row + 1, 0);
            return;
        }
        
        // 스도쿠 다 채워졌으면 출력하고 종료
        if(row == 9) {
            for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
            
            System.exit(0); // 정답을 찾았으므로 프로그램 종료 (아이디어 찾아봄)
        }
        
        // 해당 위치의 값이 0이라면 숫자 채워주기 (아이디어 찾아봄)
        if(arr[row][col] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(possibility(row, col, i)) { // 유효성 검사 통과 시
                    arr[row][col] = i; // 숫자 채우고
                    sudoku(row, col + 1); // 다음 열로 이동
                }
            }
            arr[row][col] = 0; // 모든 가능한 숫자를 확인했지만 해결책이 없을 때, 다른 숫자를 시도하기 위해 현재 위치의 숫자 초기화 
            return;
        }
        
        sudoku(row, col + 1); // 해당 위치에 숫자를 채울 수 없다고 판단되었을 때, 다른 숫자를 시도하기 위해 다음 열로 이동하는 역할
    }
    
    // 스도쿠 숫자 1 ~ 9까지 있는지 확인(이미 존재하는 숫자를 num으로 설정)
    public static boolean possibility(int row, int col, int num) { 
        
        // 행과 열 확인
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == num || arr[i][col] == num) {
                return false;
            }
        }
        
        // 3*3 확인 (아이디어 참조)
        int inside_row = row/3*3; // 3*3 칸의 row 시작점
        int inside_col = col/3*3; // 3*3 칸의 col 시작점
        
        for(int i = inside_row; i < inside_row+3; i++) {
            for(int j = inside_col; j < inside_col+3; j++) {
                if(arr[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
