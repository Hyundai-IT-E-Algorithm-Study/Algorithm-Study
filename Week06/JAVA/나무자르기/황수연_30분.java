import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] trees = new int[n];
        for (int i = 0; i < trees.length; i++) {
            trees[i] = sc.nextInt();
        }

        long min = 0;
        long max = 1000000000;
        long answer = 0;
        
        while (min <= max) {
            long mid = (min + max) / 2;
            
            long sum = 0;
            for (int i = 0; i < trees.length; i++) {
                if (trees[i] > mid) {
                    sum += trees[i] - mid;
                }
            }
            
            if (sum >= m) {
            	min = mid + 1;
            	answer = Math.max(answer, mid);
            } else {
            	max = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
