import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int[] tempArr;
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tempArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            dfs(arr[i], 0, 0);
        }
        System.out.print(sb);
    }
    public static void dfs(int curr, int currIndex, int cnt){
        tempArr[cnt] = curr;
        if(cnt < M - 1) {
            for (int node = 0; node < N; node++) {
                dfs(arr[node], node, cnt + 1);
            }
        } else {
            for(int i : tempArr)
                sb.append(i + " ");
            sb.append("\n");
        }
    }
}
