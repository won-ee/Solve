import java.io.*;
import java.util.*;

public class Main {
    static int N, K, S, X, Y;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Virus implements Comparable<Virus> {
        int type, x, y;

        public Virus(int type, int x, int y) {
            this.type = type;
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
        String[] nk = br.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);

        graph = new int[N][N];
        List<Virus> virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(row[j]);
                if (graph[i][j] != 0) {
                    virusList.add(new Virus(graph[i][j], i, j));
                }
            }
        }

        String[] sxy = br.readLine().split(" ");
        S = Integer.parseInt(sxy[0]);
        X = Integer.parseInt(sxy[1]);
        Y = Integer.parseInt(sxy[2]);

        Collections.sort(virusList);
        System.out.println(bfs(virusList));
    }

    static int bfs(List<Virus> virusList) {
        Queue<Virus> q = new LinkedList<>(virusList);
        int time = 0;

        while (!q.isEmpty()) {
            if (time == S) break;
            int size = q.size(); 

            for (int i = 0; i < size; i++) {
                Virus v = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = v.x + dx[d];
                    int ny = v.y + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && graph[nx][ny] == 0) {
                        graph[nx][ny] = v.type;
                        q.offer(new Virus(v.type, nx, ny));
                    }
                }
            }
            time++;
        }

        return graph[X - 1][Y - 1];
    }
}
