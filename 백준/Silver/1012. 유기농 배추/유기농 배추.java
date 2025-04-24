import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};
        for (int ti=0; ti<t; ti++){
            String[] tc = br.readLine().split(" ");
            int m = Integer.parseInt(tc[0]);
            int n = Integer.parseInt(tc[1]);
            int k = Integer.parseInt(tc[2]);
            int[][] arr = new int[n][m];
            for(int i=0; i<k; i++){
                String[] yx = br.readLine().split(" ");
                int y = Integer.parseInt(yx[1]);
                int x = Integer.parseInt(yx[0]);
                arr[y][x] = 1;
            }

            int ans =0;
            for (int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if (arr[i][j]==1){
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[]{i,j});
                        arr[i][j] = 0;
                        ans++;
                        while (!queue.isEmpty()){
                            int[] temp = queue.poll();
                            for(int d=0; d<4; d++){
                               int diy = dy[d] + temp[0];
                               int dix = dx[d] + temp[1];
                               if (diy<0 || dix<0 || diy>=n ||dix>=m)continue;
                               if(arr[diy][dix] == 0)continue;
                               queue.add(new int[]{diy,dix});
                               arr[diy][dix] = 0;
                            }
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
}