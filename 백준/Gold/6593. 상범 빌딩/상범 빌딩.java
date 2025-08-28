import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int l, r, c;
    static char[][][] board;
    static boolean[][][] visited;
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            board = new char[l][r][c];
            visited = new boolean[l][r][c];
            
            int startZ = 0, startX = 0, startY = 0;
            int goalZ = 0, goalX = 0, goalY = 0;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = sc.next();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = line.charAt(k);
                        if (board[i][j][k] == 'S') {
                            startZ = i;
                            startX = j;
                            startY = k;
                        } else if (board[i][j][k] == 'E') {
                            goalZ = i;
                            goalX = j;
                            goalY = k;
                        }
                    }
                }
            }
            
            sc.nextLine();

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{startZ, startX, startY, 0});
            visited[startZ][startX][startY] = true;

            int result = -1;

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int z = current[0];
                int x = current[1];
                int y = current[2];
                int d = current[3];

                if (z == goalZ && x == goalX && y == goalY) {
                    result = d;
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int nz = z + dz[i];
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nz >= 0 && nz < l && nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nz][nx][ny]) {
                        if (board[nz][nx][ny] == '.' || board[nz][nx][ny] == 'E') {
                            visited[nz][nx][ny] = true;
                            q.offer(new int[]{nz, nx, ny, d + 1});
                        }
                    }
                }
            }

            if (result != -1) {
                System.out.println("Escaped in " + result + " minute(s).");
            } else {
                System.out.println("Trapped!");
            }
        }
    }
}