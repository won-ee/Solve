import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        for (int i=0; i<n; i++){
            String[] strArr = br.readLine().split(" ");
            for (int j=0; j<strArr.length; j++){
                triangle[i][j]  = Integer.parseInt(strArr[j]);
            }
        }
        int[] dx = new int[]{-1,0};
        for (int i=1; i<n; i++){
            for (int j=0; j<=i; j++){
                int max = 0;
                for (int k=0; k<2; k++){
                    int diy = i-1;
                    int dix = dx[k] + j;
                    if (dix<0 || dix>=n)continue;
                    max = Math.max(max,triangle[diy][dix]);
                }
                triangle[i][j] = max+triangle[i][j];
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++){
            ans = Math.max(ans, triangle[n-1][i]);
        }
        System.out.println(ans);
    }
}
