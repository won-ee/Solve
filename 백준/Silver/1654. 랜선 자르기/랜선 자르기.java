import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int k = Integer.parseInt(strArr[0]);
        int n = Integer.parseInt(strArr[1]);

        long[] lan = new long[k];
        long maxLen = 0;
        for (int i = 0; i < k; i++) {
            lan[i] = Long.parseLong(br.readLine());
            if (lan[i] > maxLen) maxLen = lan[i];
        }

        long start = 1;
        long end = maxLen;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0L;

            for (int i = 0; i < k; i++) {
                count += lan[i] / mid;
            }

            if (count >= n) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(result);
    }
}
