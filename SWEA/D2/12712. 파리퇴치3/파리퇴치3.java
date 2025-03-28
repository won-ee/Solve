import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int k=1; k<t+1; k++){
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[][] arr = new int[n][n];
            for (int i=0; i<n; i++){
                String[] strArr = br.readLine().split(" ");
                for (int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(strArr[j]);
                }
            }

            int max = 0;
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++){
                    int cSum = cross(arr,i,j,m);
                    int xSum = x(arr,i,j,m);
                    int cxMax = Math.max(cSum, xSum);
                    max = Math.max(max, cxMax);
                }
            }
            sb.append("#").append(k).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
        br.close();
    }


    public static int cross(int[][] arr, int i, int j, int m) {
        int[] diy = {-1, 1, 0, 0};
        int[] dix = {0, 0, -1, 1};
        int sum = arr[i][j];

        for (int k = 0; k < 4; k++) {
            for (int l = 1; l < m; l++) {
                int dy = i + diy[k] * l;
                int dx = j + dix[k] * l;
                if (dy < 0 || dy >= arr.length || dx < 0 || dx >= arr.length) continue;
                sum += arr[dy][dx];
            }
        }
        return sum;
    }

    public static int x(int[][] arr, int i, int j, int m) {
        int[] diy = {-1, -1, 1, 1};
        int[] dix = {-1, 1, -1, 1};
        int sum = arr[i][j];

        for (int k = 0; k < 4; k++) {
            for (int l = 1; l < m; l++) {
                int dy = i + diy[k] * l;
                int dx = j + dix[k] * l;
                if (dy < 0 || dy >= arr.length || dx < 0 || dx >= arr.length) continue;
                sum += arr[dy][dx];
            }
        }
        return sum;
    }
}
