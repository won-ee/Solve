import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            q.add(a);
            visited[a] = true;
            command[a] = "";
            while (!q.isEmpty()) {
                int now = q.poll();

                if (now == b) {
                    System.out.println(command[now]);
                    break;
                }

                char[] commandArr = {'D','S','L','R'};

                for (char c : commandArr){
                    int next = -1;
                    switch (c){
                        case 'D':
                            next = D(now);
                            break;
                        case 'S':
                            next = S(now);
                            break;
                        case 'L':
                            next = L(now);
                            break;
                        case 'R':
                            next = R(now);
                            break;
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                        command[next] = command[now] + c;
                    }
                }
            }
        }
    }

    public static int D(int n) {
        int result = n * 2;
        return result % 10000;
    }

    public static int S(int n) {
        return (n == 0) ? 9999 : n - 1;
    }

    public static int L(int n) {
        return (n % 1000) * 10 + (n / 1000);
    }

    public static int R(int n) {
        return (n / 10) + (n % 10) * 1000;
    }
}