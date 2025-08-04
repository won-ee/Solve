import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);

        int[] trees = new int[N];
        strArr = br.readLine().split(" ");
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(strArr[i]);
            if (trees[i] > max) max = trees[i];
        }

        int result = binarySearch(trees, N, M, max);
        System.out.println(result);
    }

    public static int binarySearch(int[] trees, int N, int M, int max) {
        int left = 0;
        int right = max;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = getCutSum(trees, N, mid);

            if (sum >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static long getCutSum(int[] trees, int N, int height) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (trees[i] > height) {
                sum += trees[i] - height;
            }
        }
        return sum;
    }
}
