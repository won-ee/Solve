import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();

        int[] arr = new int[F + 1];
        
        int flag = -1;
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{S, 0});
        arr[S] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int now = current[0];
            int cnt = current[1];

            if (now == G) {
                flag = cnt;
                break;
            }

            int next_up = now + U;
            if (next_up <= F && arr[next_up] == 0) {
                arr[next_up] = 1;
                q.offer(new int[]{next_up, cnt + 1});
            }

            int next_down = now - D;
            if (next_down >= 1 && arr[next_down] == 0) {
                arr[next_down] = 1;
                q.offer(new int[]{next_down, cnt + 1});
            }
        }

        if (flag != -1) {
            System.out.println(flag);
        } else {
            System.out.println("use the stairs");
        }
    }
}