import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        int st = 0, maxLen = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int en = 0; en < N; en++) {
            countMap.put(arr[en], countMap.getOrDefault(arr[en], 0) + 1);

            while (countMap.size() > 2) {
                countMap.put(arr[st], countMap.get(arr[st]) - 1);
                if (countMap.get(arr[st]) == 0) {
                    countMap.remove(arr[st]);
                }
                st++;
            }

            maxLen = Math.max(maxLen, en - st + 1);
        }

        System.out.println(maxLen);
    }
}
