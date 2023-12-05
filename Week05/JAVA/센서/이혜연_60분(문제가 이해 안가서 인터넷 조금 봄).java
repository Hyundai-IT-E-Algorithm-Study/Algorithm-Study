import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        Queue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        
        for(int i = 0; i<N-1; i++)
            q.offer(arr[i+1] - arr[i]);

        int sum = 0;
        for(int i = 0; i<N-K; i++)
            sum += q.poll();

        System.out.println(sum);
    }
}
