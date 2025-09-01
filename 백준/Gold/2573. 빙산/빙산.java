import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] used;
    static int[] diy = {0, 0, 1, -1};
    static int[] dix = {1, -1, 0, 0};

    public static void bfs(int ny, int nx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ny, nx});
        used[ny][nx] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            for (int k = 0; k < 4; k++) {
                int dy = diy[k] + y;
                int dx = dix[k] + x;

                if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
                    continue;
                }

                if (arr[dy][dx] == 0) {
                    used[y][x]++;
                } else if (used[dy][dx] == 0) {
                    q.offer(new int[]{dy, dx});
                    used[dy][dx] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int ans = 0;

        while (true) {
            used = new int[N][M];
            int ice = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && used[i][j] == 0) {
                        bfs(i, j);
                        ice++;
                    }
                }
            }
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (used[i][j] != 0) {
                        arr[i][j] -= (used[i][j] - 1);
                        if (arr[i][j] < 0) {
                            arr[i][j] = 0;
                        }
                    }
                }
            }

            if (ice == 0) {
                System.out.println(0);
                return;
            }
            if (ice >= 2) {
                System.out.println(ans);
                return;
            }

            ans++;
        }
    }
}