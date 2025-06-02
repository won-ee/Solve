import java.util.*;

public class Main {
    static int n, m, min = Integer.MAX_VALUE;
    static List<int[]> home = new ArrayList<>();
    static List<int[]> chick = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) home.add(new int[]{i, j});
                if (arr[i][j] == 2) chick.add(new int[]{i, j});
            }

        comb(new ArrayList<>(), 0);
        System.out.println(min);
    }

    static void comb(List<int[]> tmp, int idx) {
        if (tmp.size() == m) {
            int sum = 0;
            for (int[] h : home) {
                int d = Integer.MAX_VALUE;
                for (int[] c : tmp)
                    d = Math.min(d, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                sum += d;
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = idx; i < chick.size(); i++) {
            tmp.add(chick.get(i));
            comb(tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
