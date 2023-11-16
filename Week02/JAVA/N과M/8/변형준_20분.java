import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        temp = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
        Arrays.sort(arr);
        for(int i = 0; i < N; i ++){
            dfs(i, 0);
        }
        System.out.println(sb);
    }

    public static void dfs(int curr, int depth){
        temp[depth] = arr[curr];
        if(depth < M - 1) {
            for (int i = curr; i < N; i++) {
                dfs(i, depth + 1);
            }
        }else{
            for(int i = 0; i < M; i++){
                sb.append(temp[i] + " ");
            }
            sb.append("\n");
        }
    }
}
