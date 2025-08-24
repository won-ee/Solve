import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static char[][] arr;
    static int[] diy = {0, 0, 1, -1};
    static int[] dix = {1, -1, 0, 0};
    static int[][] used;
    static int[][] used_b;

    public static void bfs(int ny, int nx, char key) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ny, nx});
        used[ny][nx] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int dy = diy[i] + y;
                int dx = dix[i] + x;

                if (dy < 0 || dy >= N || dx < 0 || dx >= N) {
                    continue;
                }
                if (used[dy][dx] == 1) {
                    continue;
                }
                if (arr[dy][dx] == key) {
                    used[dy][dx] = 1;
                    q.add(new int[]{dy, dx});
                }
            }
        }
    }

    public static void bfs_b(int ny, int nx, char key) {
        char ky = 'X';
        if (key == 'R') {
            ky = 'G';
        }
        if (key == 'G') {
            ky = 'R';
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ny, nx});
        used_b[ny][nx] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];

            for (int i = 0; i < 4; i++) {
                int dy = diy[i] + y;
                int dx = dix[i] + x;

                if (dy < 0 || dy >= N || dx < 0 || dx >= N) {
                    continue;
                }
                if (used_b[dy][dx] == 1) {
                    continue;
                }
                if (arr[dy][dx] == key || arr[dy][dx] == ky) {
                    used_b[dy][dx] = 1;
                    q.add(new int[]{dy, dx});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        sc.close();

        used = new int[N][N];
        used_b = new int[N][N];

        int a = 0;
        int b = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (used[i][j] == 0) {
                    bfs(i, j, arr[i][j]);
                    a++;
                }

                if (used_b[i][j] == 0) {
                    bfs_b(i, j, arr[i][j]);
                    b++;
                }
            }
        }

        System.out.println(a + " " + b);
    }
}