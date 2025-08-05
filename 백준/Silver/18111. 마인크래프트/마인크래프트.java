import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int M = Integer.parseInt(strArr[1]);
        int B = Integer.parseInt(strArr[2]);

        int[][] arr = new int[N][M];
        int max = 0;
        int min = 256;

        for (int i = 0; i < N; i++) {
            strArr = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(strArr[j]);
                if (arr[i][j] > max) max = arr[i][j];
                if (arr[i][j] < min) min = arr[i][j];
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;

        for (int h = min; h <= max; h++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int block = arr[i][j];

                    if (block > h) {
                        time += (block - h) * 2;
                        inventory += (block - h);
                    } else if (block < h) {
                        time += (h - block);
                        inventory -= (h - block);
                    }
                }
            }

            if (inventory < 0) continue;

            if (time < resultTime || (time == resultTime && h > resultHeight)) {
                resultTime = time;
                resultHeight = h;
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}
