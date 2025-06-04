import java.util.*;

public class Main {
    static int N, M, ans = 0;
    static int[][] map;
    static List<int[]> zero = new ArrayList<>();
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0)
                    zero.add(new int[]{i, j});
            }

        used = new boolean[zero.size()];
        dfs(0, map);
        System.out.println(ans);
    }

    static void dfs(int wall, int[][] arr) {
        if (wall == 3) {
            int[][] copy = deepCopy(arr);
            ans = Math.max(ans, spreadVirus(copy));
            return;
        }

        for (int i = 0; i < zero.size(); i++) {
            if (used[i]) continue;
            used[i] = true;
            int[][] copy = deepCopy(arr);
            int y = zero.get(i)[0];
            int x = zero.get(i)[1];
            copy[y][x] = 1;
            dfs(wall + 1, copy);
            used[i] = false;
        }
    }

    static int spreadVirus(int[][] arr) {
        int[][] visited = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2 && visited[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int y = cur[0];
                        int x = cur[1];
                        for (int d = 0; d < 4; d++) {
                            int ny = y + dy[d];
                            int nx = x + dx[d];
                            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                            if (arr[ny][nx] == 0 && visited[ny][nx] == 0) {
                                visited[ny][nx] = 1;
                                arr[ny][nx] = 2;
                                q.offer(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (arr[i][j] == 0)
                    cnt++;
        return cnt;
    }

    static int[][] deepCopy(int[][] src) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++)
            copy[i] = Arrays.copyOf(src[i], M);
        return copy;
    }
}
