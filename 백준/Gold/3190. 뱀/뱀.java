import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < K; i++) {
            int y = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            arr[y][x] = 2;
        }

        int L = sc.nextInt();
        Deque<int[]> move_list = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            move_list.add(new int[]{x, c});
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.addFirst(new int[]{0, 0});
        int[][] di = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int move_di = 0;
        int cnt = 0;

        while (true) {
            cnt++;
            int y = snake.peekFirst()[0];
            int x = snake.peekFirst()[1];
            int dy = y + di[move_di][0];
            int dx = x + di[move_di][1];

            if (dy < 0 || dy >= N || dx < 0 || dx >= N || isInSnake(snake, dy, dx)) break;

            if (arr[dy][dx] == 0) {
                snake.pollLast();
            } else {
                arr[dy][dx] = 0;
            }
            snake.addFirst(new int[]{dy, dx});

            if (!move_list.isEmpty() && cnt == move_list.peek()[0]) {
                int[] move = move_list.poll();
                char turn = (char) move[1];
                if (turn == 'D') {
                    move_di = (move_di + 1) % 4;
                } else if (turn == 'L') {
                    move_di = (move_di + 3) % 4;
                }
            }
        }

        System.out.println(cnt);
    }

    private static boolean isInSnake(Deque<int[]> snake, int y, int x) {
        for (int[] p : snake) {
            if (p[0] == y && p[1] == x) return true;
        }
        return false;
    }
}
