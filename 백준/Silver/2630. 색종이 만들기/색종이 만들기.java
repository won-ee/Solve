import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] strArr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        dfs(paper, 0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void dfs(int[][] paper, int x, int y, int size) {
        if (ckeck(paper, x, y, size)) {
            if (paper[x][y] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;
        dfs(paper, x, y, newSize);
        dfs(paper, x, y + newSize, newSize);
        dfs(paper, x + newSize, y, newSize);
        dfs(paper, x + newSize, y + newSize, newSize);
    }

    public static boolean ckeck(int[][] paper, int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) return false;
            }
        }
        return true;
    }
}
