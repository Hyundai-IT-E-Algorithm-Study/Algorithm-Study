//아이디어 고민과 시간초과 이슈로 인한 시간소요.
//인터넷에선 백트래킹 아이디어 참조하고, 코드는 직접 구현
//시간초과 이슈가 있을때 백준 질문게시판 살짝 참조해서 check메서드를 간소화 시킴

//백트래킹 아이디어를 사용한 이유 : 이런 구현 문제에서, 실제 스도쿠를 풀듯이 머리써서 접근하면 너무나 어려워졌음..
//nqueen처럼 컴퓨터의 반복 기능을 활용해서 백트래킹하는 구현이 수월함.
//그런데, nqueen과 다르게 dfs 깊이가 0인 값의 깊이만큼 들어가서 최대 81개까지 들어가는데, 이게 가능한가 싶어서 아이디어가 살짝 떠올라도 엄두를 못냈었음.
//하지만 오히려 9X9로 한정돼있고, 메서드 구현이 단순하기 때문에, 메서드를 가능한 작업을 덜하게(조건문 적게하는 등) 구현하면 합격이 됐음.
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

        //현재 blank에 1부터 9까지 중 스토쿠 규칙 만족하는 것만 넣고 다음 blank로 넘어가는 재귀 수행(백트래킹)
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

    //속하는 박스에 같은 값 있는지 체크 하는 메서드
    static boolean checkBox(int value, int boxY, int boxX){
        for (int y=boxY; y<boxY+3; y++){
            for (int x=boxX; x<boxX+3; x++){
                if (sudoku[y][x] == value) return false;
            }
        }
        return true;
    }

}
