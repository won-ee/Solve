import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static int apart;
    static int[] diy = {0, 0, 1, -1};
    static int[] dix = {1, -1, 0, 0};
    static List<Integer> lst = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    bfs(i, j);
                    apart++;
                }
            }
        }

        System.out.println(apart);
        Collections.sort(lst);
        for (int count : lst) {
            System.out.println(count);
        }
    }

    public static void bfs(int sty, int stx) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sty, stx});
        int cnt = 0;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int y = current[0];
            int x = current[1];
            cnt++;

            for (int i = 0; i < 4; i++) {
                int dy = diy[i] + y;
                int dx = dix[i] + x;

                if (dy < 0 || dx < 0 || dy >= N || dx >= N) {
                    continue;
                }
                
                if (arr[dy][dx] == 0) {
                    continue;
                }
                
                arr[dy][dx] = 0;
                q.add(new int[]{dy, dx});
            }
        }
        lst.add(cnt);
    }
}