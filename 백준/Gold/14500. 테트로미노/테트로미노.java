import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int max = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i,j,1,arr[i][j]);
                visited[i][j] = false;

                checkT(i,j);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 4){
            max = Math.max(max, sum);
            return;
        }

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, cnt + 1, sum + arr[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void checkT(int x, int y) {
        if (x > 0 && y > 0 && y < M - 1) {
            max = Math.max(max, arr[x][y] + arr[x-1][y] + arr[x][y-1] + arr[x][y+1]);
        }
        
        if (x < N - 1 && y > 0 && y < M - 1) {
            max = Math.max(max, arr[x][y] + arr[x+1][y] + arr[x][y-1] + arr[x][y+1]);
        }
        
        if (x > 0 && x < N - 1 && y < M - 1) {
            max = Math.max(max, arr[x][y] + arr[x-1][y] + arr[x+1][y] + arr[x][y+1]);
        }
        
        if (x > 0 && x < N - 1 && y > 0) {
            max = Math.max(max, arr[x][y] + arr[x-1][y] + arr[x+1][y] + arr[x][y-1]);
        }
    }
}