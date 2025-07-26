import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Long> dp = new ArrayList<>();
        long[] arr = new long[]{1, 1, 1, 2, 2, 3, 4, 5, 7, 9};

        for (int i = 0; i < 10; i++) {
            dp.add(arr[i]);
        }

        for (int i = 10; i <= 100; i++) {
            long tmp = dp.get(i-1) + dp.get(i-5);
            dp.add(tmp);
        }

        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp.get(n-1));
        }
    }
}
