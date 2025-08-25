import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static char[][] arr;
    static int[][] fire_time;
    static int[][] sang_time;
    static int[] diy = {0, 0, -1, 1};
    static int[] dix = {1, -1, 0, 0};

    static class Node {
        int y, x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            fire_time = new int[h][w];
            sang_time = new int[h][w];
            Queue<Node> fire_q = new LinkedList<>();
            Queue<Node> sang_q = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = line.charAt(j);
                    fire_time[i][j] = -1;
                    sang_time[i][j] = -1;

                    if (arr[i][j] == '*') {
                        fire_q.add(new Node(i, j));
                        fire_time[i][j] = 0;
                    }
                    if (arr[i][j] == '@') {
                        sang_q.add(new Node(i, j));
                        sang_time[i][j] = 0;
                    }
                }
            }

            while (!fire_q.isEmpty()) {
                Node curr = fire_q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = curr.y + diy[i];
                    int nx = curr.x + dix[i];

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                    if (fire_time[ny][nx] != -1 || arr[ny][nx] == '#') continue;

                    fire_q.add(new Node(ny, nx));
                    fire_time[ny][nx] = fire_time[curr.y][curr.x] + 1;
                }
            }
            
            int ans = -1;
            while (!sang_q.isEmpty()) {
                Node curr = sang_q.poll();
                
                if (curr.y == 0 || curr.y == h - 1 || curr.x == 0 || curr.x == w - 1) {
                    ans = sang_time[curr.y][curr.x] + 1;
                    break;
                }
                
                for (int i = 0; i < 4; i++) {
                    int ny = curr.y + diy[i];
                    int nx = curr.x + dix[i];
                    int next_time = sang_time[curr.y][curr.x] + 1;

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                    if (sang_time[ny][nx] != -1 || arr[ny][nx] == '#') continue;
                    
                    if (fire_time[ny][nx] != -1 && fire_time[ny][nx] <= next_time) continue;

                    sang_q.add(new Node(ny, nx));
                    sang_time[ny][nx] = next_time;
                }
            }
            
            if (ans != -1) {
                System.out.println(ans);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}