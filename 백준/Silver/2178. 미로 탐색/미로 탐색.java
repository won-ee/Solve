import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static int[][] arr;
    public static int[] dy;
    public static int[] dx;
    public static int [][] visited;
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        arr = new int[n][m];
        dy = new int[]{1,-1,0,0};
        dx = new int[]{0,0,1,-1};
        visited = new int[n][m];

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<m; j++){
                char cha = str.charAt(j);
                int k = Integer.parseInt(String.valueOf(cha));
                arr[i][j] = k;
            }
        }
        visited[0][0] = 1;
        System.out.println(bfs(0,0));

    }
    public static int bfs(int i,int j){
        int diy;
        int dix;
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j,0});

        while (!q.isEmpty()){
            int[] temp = q.poll();
            int y = temp[0];
            int x = temp[1];
            int cnt = temp[2];
            if (y == n-1 && x == m-1){
                return cnt+1;
            }
            for (int k=0; k<4; k++){
                diy = y + dy[k];
                dix = x + dx[k];
                if (diy<0 || diy>=n || dix<0 || dix>=m){
                    continue;
                }
                if(visited[diy][dix]== 0 && arr[diy][dix] == 1){
                    visited[diy][dix] = 1;
                    q.add(new int[]{diy,dix,cnt+1});
                }
            }
        }
        return -1;
    }
}
