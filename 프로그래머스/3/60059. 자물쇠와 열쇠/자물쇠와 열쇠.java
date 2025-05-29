public class Solution {
    public boolean solution(int[][] k, int[][] l) {
        int m = k.length, n = l.length, sz = n + 2 * (m - 1);

        for (int r = 0; r < 4; r++) {
            k = rot(k);

            for (int x = 0; x <= sz - m; x++) {
                for (int y = 0; y <= sz - m; y++) {
                    int[][] tmp = new int[sz][sz];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            tmp[i + m - 1][j + m - 1] = l[i][j];
                        }
                    }

                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            tmp[x + i][y + j] += k[i][j];
                        }
                    }

                    if (chk(tmp, m, n)) return true;
                }
            }
        }

        return false;
    }

    private int[][] rot(int[][] a) {
        int m = a.length;
        int[][] r = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                r[j][m - 1 - i] = a[i][j];
            }
        }
        return r;
    }

    private boolean chk(int[][] a, int m, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i + m - 1][j + m - 1] != 1) return false;
            }
        }
        return true;
    }
}
