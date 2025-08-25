import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dix = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] diy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int l, startX, startY, targetX, targetY;
    static boolean[][] visited;
    static Queue<Node> q;

    private static class Node {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int bfs() {
        if (startX == targetX && startY == targetY) {
            return 0;
        }

        q = new LinkedList<>();
        visited = new boolean[l][l];

        q.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.x == targetX && current.y == targetY) {
                return current.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = current.x + dix[i];
                int nextY = current.y + diy[i];

                if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new Node(nextX, nextY, current.cnt + 1));
                }
            }
        }
        return -1; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            l = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            int result = bfs();
            bw.write(result + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}