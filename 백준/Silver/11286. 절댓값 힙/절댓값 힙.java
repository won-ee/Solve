import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->{
            int abs = Integer.compare(Math.abs(a),Math.abs(b));

            if (abs != 0) return abs;

            return Integer.compare(a,b);
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
                continue;
            }
            if (pq.size() == 0) {
                System.out.println(0);
                continue;
            }
            System.out.println(pq.poll());
        }
    }
}