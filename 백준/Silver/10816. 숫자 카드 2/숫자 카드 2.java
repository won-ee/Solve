import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            map.merge(num, 1, Integer::sum);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++){
            Integer count = map.get(Integer.parseInt(st.nextToken()));
            if (count == null){
                sb.append(0).append(" ");
            }else {
                sb.append(count).append(" ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
