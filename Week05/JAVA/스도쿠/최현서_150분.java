//아이디어 고민과 시간초과 이슈로 인한 시간소요.
import java.util.*;

public class Main {
    static int[][] sudoku = new int[9][9];
    static int blankLen;
    static List<Integer> blankY = new ArrayList<>();
    static List<Integer> blankX = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int y=0; y<9; y++){
            for(int x=0; x<9; x++){
                sudoku[y][x]= Integer.parseInt(sc.next());
            }
        }

        //0인 y,x좌표 blankY, blankX에 넣음
        for(int y=0; y<9; y++){
            for(int x=0; x<9; x++){
                if (sudoku[y][x] == 0){
                    blankY.add(y);
                    blankX.add(x);
                }
            }
        }

        blankLen = blankY.size();

        sudokuDFS(0);


    }

    static void sudokuDFS(int n){
        //n이 blankLen까지 오면, 모든 blank를 다 스도쿠규칙 만족하도록 채웠다는 의미
        //이것을 출력하고, exit(하나의 경우만 출력하면 되기 때문)

        if (n==blankLen){
            for (int[] line: sudoku){
                for (int i=0; i<9; i++){
                    System.out.print(line[i]+" ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        int y = blankY.get(n);
        int x = blankX.get(n);
        //해당 좌표가 속하는 3X3 박스의 시작 y,x좌표
        int boxY = y - (y%3);
        int boxX = x - (x%3);

        //blank에 1부터 9까지 넣어서 스토쿠 규칙 만족하는 것만 재귀 수행(백트래킹)
        for (int value=1; value<=9; value++){
            if(checkLine(value,y,x) && checkBox(value,boxY,boxX)){
                sudoku[y][x] = value;
                sudokuDFS(n+1);
                //재귀 수행 후 다른 경우에 영향 안 주도록 0으로 초기화
                sudoku[y][x] = 0;
            }
        }
    }

    //가로줄 세로줄에 같은 값 있는지 체크 하는 함수
    static boolean checkLine(int value, int y, int x){
        for (int i=0; i<9; i++){
            if (sudoku[i][x]==value || sudoku[y][i]==value) return false;
        }
        return true;
    }

    //속하는 박스에 같은 값 있는지 체크 하는 함수
    static boolean checkBox(int value, int boxY, int boxX){
        for (int y=boxY; y<boxY+3; y++){
            for (int x=boxX; x<boxX+3; x++){
                if (sudoku[y][x] == value) return false;
            }
        }
        return true;
    }

}
