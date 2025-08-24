import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int m, n, h;
    static int[][][] arr;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int z = current[0];
            int y = current[1];
            int x = current[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) {
                    continue;
                }

                if (arr[nz][ny][nx] == 0 && !visited[nz][ny][nx]) {
                    queue.add(new int[]{nz, ny, nx});
                    visited[nz][ny][nx] = true;
                    arr[nz][ny][nx] = arr[z][y][x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        arr = new int[h][n][m];
        visited = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = sc.nextInt();
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 1 && !visited[i][j][k]) {
                        queue.add(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        bfs();

        int answer = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        sc.close();
                        return;
                    }
                    answer = Math.max(answer, arr[i][j][k]);
                }
            }
        }
        System.out.println(answer - 1);
        sc.close();
    }
}