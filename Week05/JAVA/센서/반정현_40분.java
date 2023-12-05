import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        if (k >= n) {
            System.out.println(0);
            return;
        }
        int[] sensors = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
       

        Arrays.sort(sensors);

        int[] distances = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(distances);
 
        int result = 0;
        for (int i = 0; i < k-1; i++) {
            distances[n - 2 - i] = 0;
        }

        for (int distance : distances) {
            result += distance;
        }

        System.out.println(result);
    }
}
