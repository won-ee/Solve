import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[101];
        for (int i = 0; i < N + M; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            arr[st] = ed;
        }

        boolean[] used = new boolean[101];
        Queue<int[]> q = new LinkedList<>();

        used[1] = true;
        q.add(new int[]{0, 1});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cnt = current[0];
            int now = current[1];

            if (now == 100) {
                System.out.println(cnt);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100) {
                    continue;
                }

                if (arr[next] != 0) {
                    next = arr[next];
                }

                if (!used[next]) {
                    used[next] = true;
                    q.add(new int[]{cnt + 1, next});
                }
            }
        }
        sc.close();
    }
}