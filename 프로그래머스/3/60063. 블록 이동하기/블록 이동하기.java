import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static int[] dy = new int[]{-1, 1, 0, 0};
    public static int[] dx = new int[]{0, 0, -1, 1};

    class Robot {
        int y1, x1, y2, x2, time;
        Robot(int y1, int x1, int y2, int x2, int time) {
            this.y1 = y1; this.x1 = x1;
            this.y2 = y2; this.x2 = x2;
            this.time = time;
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        Queue<Robot> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[n][n][n][n];

        q.add(new Robot(0, 0, 0, 1, 0));
        visited[0][0][0][1] = true;

        while (!q.isEmpty()) {
            Robot robot = q.poll();

            if ((robot.y1 == n - 1 && robot.x1 == n - 1) || (robot.y2 == n - 1 && robot.x2 == n - 1)) {
                return robot.time;
            }

            // 이동
            for (int i = 0; i < 4; i++) {
                int ny1 = robot.y1 + dy[i], nx1 = robot.x1 + dx[i];
                int ny2 = robot.y2 + dy[i], nx2 = robot.x2 + dx[i];

                if (check(ny1, nx1, n, board) && check(ny2, nx2, n, board)) {
                    if (!visited[ny1][nx1][ny2][nx2]) {
                        visited[ny1][nx1][ny2][nx2] = true;
                        q.add(new Robot(ny1, nx1, ny2, nx2, robot.time + 1));
                    }
                }
            }

            // 회전
            if (robot.y1 == robot.y2) { // 가로 방향
                for (int d = -1; d <= 1; d += 2) {
                    if (check(robot.y1 + d, robot.x1, n, board) && check(robot.y2 + d, robot.x2, n, board)) {
                        if (!visited[robot.y1][robot.x1][robot.y1 + d][robot.x1]) {
                            visited[robot.y1][robot.x1][robot.y1 + d][robot.x1] = true;
                            q.add(new Robot(robot.y1, robot.x1, robot.y1 + d, robot.x1, robot.time + 1));
                        }
                        if (!visited[robot.y2][robot.x2][robot.y2 + d][robot.x2]) {
                            visited[robot.y2][robot.x2][robot.y2 + d][robot.x2] = true;
                            q.add(new Robot(robot.y2, robot.x2, robot.y2 + d, robot.x2, robot.time + 1));
                        }
                    }
                }
            } else if (robot.x1 == robot.x2) { // 세로 방향
                for (int d = -1; d <= 1; d += 2) {
                    if (check(robot.y1, robot.x1 + d, n, board) && check(robot.y2, robot.x2 + d, n, board)) {
                        if (!visited[robot.y1][robot.x1][robot.y1][robot.x1 + d]) {
                            visited[robot.y1][robot.x1][robot.y1][robot.x1 + d] = true;
                            q.add(new Robot(robot.y1, robot.x1, robot.y1, robot.x1 + d, robot.time + 1));
                        }
                        if (!visited[robot.y2][robot.x2][robot.y2][robot.x2 + d]) {
                            visited[robot.y2][robot.x2][robot.y2][robot.x2 + d] = true;
                            q.add(new Robot(robot.y2, robot.x2, robot.y2, robot.x2 + d, robot.time + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    private boolean check(int y, int x, int n, int[][] board) {
        return y >= 0 && y < n && x >= 0 && x < n && board[y][x] == 0;
    }
}
