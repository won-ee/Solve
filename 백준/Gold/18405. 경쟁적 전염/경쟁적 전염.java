import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Virus implements Comparable<Virus> {
        int type, time, x, y;
        public Virus(int type, int time, int x, int y) {
            this.type = type;
            this.time = time;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Virus o) {
            return this.type - o.type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nkStr = br.readLine().split(" ");
        n = Integer.parseInt(nkStr[0]);
        k = Integer.parseInt(nkStr[1]);

        arr = new int[n][n];
        List<Virus> virusList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
                if (arr[i][j] != 0) {
                    virusList.add(new Virus(arr[i][j], 0, i, j));
                }
            }
        }

        Collections.sort(virusList);

        Queue<Virus> queue = new LinkedList<>(virusList);

        String[] sxy = br.readLine().split(" ");
        int S = Integer.parseInt(sxy[0]);
        int X = Integer.parseInt(sxy[1]) - 1;
        int Y = Integer.parseInt(sxy[2]) - 1;

        while (!queue.isEmpty()) {
            Virus v = queue.poll();
            if (v.time == S) break;

            for (int i = 0; i < 4; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = v.type;
                        queue.offer(new Virus(v.type, v.time + 1, nx, ny));
                    }
                }
            }
        }

        System.out.println(arr[X][Y]);
    }
}
