import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;
    static int N, M;
    static int[] arr;
    static boolean[] isVisited;
    static int[] printArr;
    static int depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isVisited = new boolean[N];
        printArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        depth = 0;
        sb = new StringBuilder();
        dfs(0, depth);
        System.out.print(sb);
    }
    public static void dfs(int currIdx, int depth){
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(printArr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                printArr[depth] = arr[i];
                dfs(i + 1, depth + 1);
                isVisited[i] = false;
            }

        }
    }
}
