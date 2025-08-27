import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] visit;
    static int[] diy = {0, 0, 1, -1};
    static int[] dix = {1, -1, 0, 0};

    public static void bfs(int ny, int nx, int nk) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ny, nx});
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            for (int l = 0; l < 4; l++) {
                int dy = diy[l] + y;
                int dx = dix[l] + x;

                if (dy < 0 || dy >= N || dx < 0 || dx >= N) {
                    continue;
                }
                if (arr[dy][dx] <= nk) {
                    continue;
                }
                if (visit[dy][dx] == 1) {
                    continue;
                }
                visit[dy][dx] = 1;
                q.offer(new int[]{dy, dx});
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int MAX = 0;
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] > MAX) {
                    MAX = arr[i][j];
                }
            }
        }

        int[] ans = new int[MAX + 1];
        
        for (int k = 0; k <= MAX; k++) {
            visit = new int[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j] == 0 && arr[i][j] > k) {
                        visit[i][j] = 1;
                        bfs(i, j, k);
                        cnt++;
                    }
                }
            }
            ans[k] = cnt;
        }

        int maxAns = 0;
        for (int count : ans) {
            if (count > maxAns) {
                maxAns = count;
            }
        }

        if (maxAns == 0) {
            System.out.println(1);
        } else {
            System.out.println(maxAns);
        }
    }
}