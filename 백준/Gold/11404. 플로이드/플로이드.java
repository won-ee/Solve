import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        long[][] arr = new long[city + 1][city + 1];

        for (int i = 0; i <= city; i++) {
            Arrays.fill(arr[i], Long.MAX_VALUE);
        }

        for (int i = 1; i <= city; i++) {
            arr[i][i] = 0;
        }

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = Math.min(arr[a][b], c);
        }

        for (int k = 1; k <= city; k++) {
            for (int i = 1; i <= city; i++) {
                for (int j = 1; j <= city; j++) {
                    if (arr[i][k] != Long.MAX_VALUE && arr[k][j] != Long.MAX_VALUE) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i <= city; i++) {
            for (int j = 1; j <= city; j++) {
                if (arr[i][j] == Long.MAX_VALUE) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
