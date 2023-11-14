import java.io.*;
import java.util.*;

public class Main {

    static boolean[] isVisited;
    static boolean[] isVisitedTemp;
    static int[] arr;
    static int[] tempArr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tempArr = new int[M];
        isVisited = new boolean[N];
        isVisitedTemp = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            isVisited[i] = true;
            for(int j = 0; j < N; j++){
                isVisitedTemp[j] = isVisited[j];
            }

            dfs(arr[i], i, 0);
        }
    }
    public static void dfs(int curr, int currIndex, int cnt){
        tempArr[cnt] = curr;
        isVisitedTemp[currIndex] = true;
        if(cnt < M - 1) {
            for (int node = currIndex; node < N; node++) {
                if (!isVisitedTemp[node]) {
                    dfs(arr[node], node, cnt + 1);
                    for(int j = 0; j < N; j++){
                        isVisitedTemp[j] = isVisited[j];
                    }
                }
            }
        } else {
            for(int i : tempArr)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
