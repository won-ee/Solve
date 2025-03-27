import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;
            map.merge(str, 1, Integer::sum);
            if (max < map.get(str)) max = map.get(str);
        }
        ArrayList<String>[] arr = new ArrayList[max + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        map.forEach((key, val) -> arr[val].add(key));
        StringBuilder sb = new StringBuilder();
        for (int i = max; i >= 0; i--) {
            if (arr[i].isEmpty()) continue;
            if (arr[i].size() > 1) {
                arr[i].sort(((a,b) -> {
                    if (a.length() !=b.length()){
                        return b.length()-a.length();
                    }else {
                        return a.compareTo(b);
                    }
                }));
            }
            for (int j=0; j<arr[i].size(); j++){
                sb.append(arr[i].get(j)).append("\n");
            }
        }
        System.out.println(sb);
    }
}