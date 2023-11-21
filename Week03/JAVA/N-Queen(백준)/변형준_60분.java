import java.io.*;

public class Main {

    static int N;
    static int[] locations;
    static boolean[] isVisited;
    static int cnt = 0;

    //1~N 까지의 수를 배치하고 대각선에 없는 경우만 따짐.
    //백트래킹으로 나열
    //대각선에 있는지 판단
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            locations = new int[N];
            isVisited = new boolean[N];
            backtracking(i, 0);
        }

        System.out.print(cnt);
    }

    public static void backtracking(int loca, int depth){
        locations[depth] = loca;
        isVisited[loca] = true;
        if(depth == N - 1){
            cnt++;
            return;
        }
        for(int i = 0; i < N; i++){
            if(!isVisited[i] && !isLine(i, depth + 1)) {
                backtracking(i, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    public static boolean isLine(int x, int index){
        for(int i = 0; i < index; i++){
            if(Math.abs(locations[i] - x) == Math.abs(i - index)){
                return true;
            }
        }
        return false;
    }
}
