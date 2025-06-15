import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] pos = new int[n];
        
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            pos[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(pos);
        
        int ans = pos[(n - 1) / 2];
        System.out.println(ans);
    }
}
