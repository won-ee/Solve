import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lst.add(Integer.parseInt(st.nextToken()));
        }
        lst.sort(null);
        for (int i = 0; i < N; i++) {
            if (lst.get(i) <=L) {
                L++;
            }
        }
        System.out.println(L);
    }
}