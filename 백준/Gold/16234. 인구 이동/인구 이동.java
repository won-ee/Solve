import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    static int[][] border;
    static int[][] backup;
    static boolean moved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nlr = br.readLine().split(" ");
        N = Integer.parseInt(nlr[0]);
        L = Integer.parseInt(nlr[1]);
        R = Integer.parseInt(nlr[2]);

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
            }
        }

        int ans = 0;

        while (true) {
            border = new int[N][N];
            backup = new int[N][N];
            for (int i = 0; i < N; i++) {
                backup[i] = Arrays.copyOf(arr[i], N);
            }

            moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (border[i][j] == 0) {
                        bfs(i, j);
                    }
                }
            }

            if (!moved) break;

            for (int i = 0; i < N; i++) {
                arr[i] = Arrays.copyOf(backup[i], N);
            }

            ans++;
        }

        System.out.println(ans);
    }

    static void bfs(int sy, int sx) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sy, sx});

        Set<String> people = new HashSet<>();
        people.add(sy + "," + sx);

        border[sy][sx] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if (border[ny][nx] == 1) continue;

                int diff = Math.abs(arr[y][x] - arr[ny][nx]);
                if (L <= diff && diff <= R) {
                    border[ny][nx] = 1;
                    q.offer(new int[]{ny, nx});
                    people.add(ny + "," + nx);
                }
            }
        }

        if (people.size() == 1) return;

        moved = true;
        int total = 0;
        for (String pos : people) {
            String[] parts = pos.split(",");
            int y = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);
            total += arr[y][x];
        }

        int avg = total / people.size();

        for (String pos : people) {
            String[] parts = pos.split(",");
            int y = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);
            backup[y][x] = avg;
        }
    }
}
