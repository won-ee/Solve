import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int day = arr[i][0];
            int money = arr[i][1];
            if (i + day > n) continue;
            dp[i] += money;

            for (int j = i + day; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[i]);
            }
        }

        int max = 0;
        for (int val : dp) {
            max = Math.max(max, val);
        }

        System.out.println(max);
    }
}