import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int mx = 2000000000;

        int start = 1;
        while (start <= mx) {
            int mid = (start + mx) / 2;
            long total = 0;
            for (int value : arr) {
                if (value - mid > 0) {
                    total += value - mid;
                }
            }
            if (total < N) {
                mx = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(mx);
    }
}
