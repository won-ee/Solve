import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int n = Integer.parseInt(st.nextToken());
       int m = Integer.parseInt(st.nextToken());
       HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split(" ");
            map.put(strArr[0],strArr[1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            sb.append(map.get(str)).append("\n");
        }
        System.out.println(sb);
    }
}
