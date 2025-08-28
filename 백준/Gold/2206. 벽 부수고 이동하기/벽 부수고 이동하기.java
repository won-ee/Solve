import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][][] used;
    static int[] diy = {0, 0, 1, -1};
    static int[] dix = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); 

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        used = new int[N][M][2];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1, 0}); 
        used[0][0][0] = 1;

        int ans = -1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];
            int cnt = current[2];
            int b = current[3];

            if (y == N - 1 && x == M - 1) {
                ans = cnt;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dy = y + diy[i];
                int dx = x + dix[i];

                if (dy < 0 || dy >= N || dx < 0 || dx >= M) {
                    continue;
                }

                if (arr[dy][dx] == 1 && b == 0) {
                    if (used[dy][dx][1] == 0) {
                        used[dy][dx][1] = 1;
                        q.offer(new int[]{dy, dx, cnt + 1, 1});
                    }
                } else if (arr[dy][dx] == 0) {
                    if (used[dy][dx][b] == 0) {
                        used[dy][dx][b] = 1;
                        q.offer(new int[]{dy, dx, cnt + 1, b});
                    }
                }
            }
        }

        System.out.println(ans);
    }
}