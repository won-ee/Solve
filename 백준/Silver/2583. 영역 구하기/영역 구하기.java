import java.util.*;
import java.io.*;

public class Main {
    static int m, n, k;
    static int[][] maps;
    static boolean[][] used;
    static int sums;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        maps = new int[m][n];
        used = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) {
                for (int l = x1; l < x2; l++) {
                    maps[j][l] = 1;
                }
            }
        }

        List<Integer> poss = new ArrayList<>();
        int cnt = 0;

        for (int j = 0; j < m; j++) {
            for (int l = 0; l < n; l++) {
                if (maps[j][l] == 0 && !used[j][l]) {
                    sums = 0;
                    sol(j, l);
                    poss.add(sums);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(poss);
        for (int ss : poss) {
            System.out.print(ss + " ");
        }
    }

    public static void sol(int y, int x) {
        used[y][x] = true;
        sums++;

        for (int s = 0; s < 4; s++) {
            int nowy = dy[s] + y;
            int nowx = dx[s] + x;

            if (nowy < 0 || nowx < 0 || nowy >= m || nowx >= n) {
                continue;
            }

            if (maps[nowy][nowx] == 1) {
                continue;
            }

            if (used[nowy][nowx]) {
                continue;
            }

            sol(nowy, nowx);
        }
    }
}