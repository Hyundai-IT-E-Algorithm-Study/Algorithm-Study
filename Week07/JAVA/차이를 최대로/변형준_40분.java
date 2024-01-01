import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|의 최대값
        // 백트래킹 브루트포스
        int max = 0;
        do {
            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(arr[i] - arr[i+1]);
            }
            max = Math.max(max, sum);
        } while(nextPermutation(arr));

        System.out.println(max);

    }

    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        //arr[i - 1] < arr[i]인 i중 가장 큰 값 찾기
        while(i > 0 && arr[i - 1] >= arr[i]) i--;

        if(i <= 0) return false;

        int j = arr.length - 1;
        //arr[j] > arr[i - 1]인 j중 가장 큰 값 찾기
        while(arr[j] <= arr[i - 1]) j--;

        swap(arr, i - 1, j);

        j = arr.length - 1;
        while(i < j) swap(arr, i++, j--);

        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
