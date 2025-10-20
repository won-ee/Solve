import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<long[]> q = new LinkedList<>();


        q.offer(new long[]{A, 1});

        long ans = -1;

        while (!q.isEmpty()){
            long[] tmp = q.poll();
            long n = tmp[0];
            long cnt = tmp[1];

            if (n == B){
                ans = cnt;
                break;
            }

            long nextCnt = cnt + 1;

            long next1 = n * 2;
            if (next1 <= B) {
                q.offer(new long[]{next1, nextCnt});
            }

            long next2 = n * 10 + 1;
            if (next2 <= B ) {
                q.offer(new long[]{next2, nextCnt});
            }
        }

        System.out.println(ans);
    }
}