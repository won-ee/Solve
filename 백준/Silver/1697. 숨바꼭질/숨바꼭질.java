import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        if (N >= M) {
            System.out.println(N - M);
            return;
        }

        int[] visited = new int[200001];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        visited[N] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int subin = current[0];
            int cnt = current[1];

            if (subin == M) {
                System.out.println(cnt);
                return;
            }

            int[] next = {subin + 1, subin - 1, subin * 2};
            for (int nxt : next) {
                if (nxt >= 0 && nxt <= 200000 && visited[nxt] == 0) {
                    visited[nxt] = 1;
                    q.add(new int[]{nxt, cnt + 1});
                }
            }
        }
    }
}