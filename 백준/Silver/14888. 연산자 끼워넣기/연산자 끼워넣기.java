import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] op = new int[4]; // + - * /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String[] a = br.readLine().split(" ");
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(a[i]);

        String[] o = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) op[i] = Integer.parseInt(o[i]);

        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int idx, int val) {
        if (idx == n) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;

                int next = 0;
                if (i == 0) next = val + arr[idx];
                else if (i == 1) next = val - arr[idx];
                else if (i == 2) next = val * arr[idx];
                else {
                    if (val < 0) next = -(-val / arr[idx]);
                    else next = val / arr[idx];
                }

                dfs(idx + 1, next);
                op[i]++;
            }
        }
    }
}
