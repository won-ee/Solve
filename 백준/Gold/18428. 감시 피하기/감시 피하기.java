import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static List<int[]> t = new ArrayList<>();
    static List<int[]> empty = new ArrayList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean ok = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = row[j].charAt(0);
                if (map[i][j] == 'T') t.add(new int[]{i, j});
                if (map[i][j] == 'X') empty.add(new int[]{i, j});
            }
        }

        comb(0, 0);
        System.out.println(ok ? "YES" : "NO");
    }

    static void comb(int cnt, int start) {
        if (cnt == 3) {
            if (check()) ok = true;
            return;
        }

        for (int i = start; i < empty.size(); i++) {
            int[] cur = empty.get(i);
            map[cur[0]][cur[1]] = 'O';
            comb(cnt + 1, i + 1);
            map[cur[0]][cur[1]] = 'X';
        }
    }

    static boolean check() {
        for (int[] tt : t) {
            for (int d = 0; d < 4; d++) {
                int x = tt[0], y = tt[1];
                while (true) {
                    x += dx[d];
                    y += dy[d];
                    if (x < 0 || y < 0 || x >= n || y >= n) break;
                    if (map[x][y] == 'O') break;
                    if (map[x][y] == 'S') return false;
                }
            }
        }
        return true;
    }
}
