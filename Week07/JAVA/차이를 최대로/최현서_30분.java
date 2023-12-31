import java.util.Scanner;

public class Main {
    static int N, maxSum, currSum, depth;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        visited = new boolean[N];

        for (int i=0; i<N; i++){
            currSum=0;
            visited[i] = true;
            depth=1;
            dfs(arr[i]);
            visited[i] = false;
        }
        System.out.println(maxSum);
    }

    static void dfs(int start){
        if (depth==N){
            if(currSum > maxSum) maxSum = currSum;
            return;
        }
        depth++;
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            currSum+=Math.abs(start-arr[i]);
            dfs(arr[i]);
            currSum-=Math.abs(start-arr[i]);
            visited[i] = false;
        }
        depth--;
    }
}
