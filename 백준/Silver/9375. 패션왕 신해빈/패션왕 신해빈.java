import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st;
            HashMap<String,ArrayList<String>> map = new HashMap<>();
            ArrayList<String> keyList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                if (map.get(type) == null){
                    keyList.add(type);
                    ArrayList<String> lst = new ArrayList<>();
                    lst.add(name);
                    map.put(type, lst);
                }else {
                    map.get(type).add(name);
                }
            }
            int ans = 1;
            for (String key : map.keySet()) {
                ans *= (map.get(key).size() + 1);
            }
            ans -= 1;
            System.out.println(ans);
        }
    }
}
