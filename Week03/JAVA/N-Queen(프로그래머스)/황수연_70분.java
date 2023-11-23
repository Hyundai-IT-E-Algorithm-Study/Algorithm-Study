import java.util.*;

class Solution {
    int[] queen; // 일차원 배열 아이디어 찾아봄
    int count = 0;
    public int solution(int n) {
        queen = new int[n]; // 초기화
        backT(n, 0); // 초기화
        return count;
    }
    
    // 재귀 호출 부분
    public void backT(int n, int depth) {
        if (depth == n) { // 퀸 그 위치에 다 놓았다면
            count++; // 퀸 개수 증가
            return;
        }

        for (int i = 0; i < n; i++) {
            queen[depth] = i;
            if (possible(depth)) { // 퀸을 놓을 수 있다면
                backT(n, depth + 1); // 다음 행 재귀 탐색
            }
        }
    }
    
    // 퀸 이동 가능 여부 체크 부분: 같은 열, 같은 행, 대각선 상에 위치하지 않는지 확인
    public boolean possible(int depth) {
        for(int i=0; i<depth; i++) {
            if(queen[i] == queen[depth]) { // 같은 행, 열일 때
                return false;
            }
            // 대각선 아이디어 찾아봄
            else if(Math.abs(depth - i) == Math.abs(queen[depth] - queen[i])) { // 같은 대각선일 때
                return false;
            }
        }
        return true;
    }
}
