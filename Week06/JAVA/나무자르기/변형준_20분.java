import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int low = 0;
        int high = trees[N - 1];
        System.out.println(binarySearch(trees, low, high, M));

    }

    public static int binarySearch(int[] trees, int low, int high, int M) {
    	int mid = 0;
    	long sum = 0;
    	int height = 0;

    	while(low <= high) {
            mid = (low + high) / 2;
            sum = 0;
            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }
            if(sum >= M) {
                height = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return height;
    }
}
