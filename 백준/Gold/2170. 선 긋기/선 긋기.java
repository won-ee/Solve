import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int start = arr[0][0];
        int end = arr[0][1];
        int total = 0;

        for (int i = 1; i < n; i++) {
            int curStart = arr[i][0];
            int curEnd = arr[i][1];

            if (curStart <= end) {
                end = Math.max(end, curEnd);
            } else {
                total += end - start;
                start = curStart;
                end = curEnd;
            }
        }

        total += end - start;

        System.out.println(total);
    }
}
