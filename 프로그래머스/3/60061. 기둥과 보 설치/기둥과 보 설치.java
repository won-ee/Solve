import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        List<int[]> arr = new ArrayList<>();

        for (int[] f : build_frame) {
            int x = f[0], y = f[1], a = f[2], b = f[3];

            if (b == 1) {
                arr.add(new int[]{x, y, a});
                if (!chk(arr)) arr.remove(arr.size() - 1);
            } else {
                int idx = -1;
                for (int i = 0; i < arr.size(); i++) {
                    int[] s = arr.get(i);
                    if (s[0] == x && s[1] == y && s[2] == a) {
                        idx = i;
                        break;
                    }
                }
                int[] tmp = arr.remove(idx);
                if (!chk(arr)) arr.add(tmp);
            }
        }

        arr.sort((a1, a2) -> {
            if (a1[0] != a2[0]) return a1[0] - a2[0];
            if (a1[1] != a2[1]) return a1[1] - a2[1];
            return a1[2] - a2[2];
        });

        int[][] answer = new int[arr.size()][3];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }

    boolean chk(List<int[]> arr) {
        for (int[] s : arr) {
            int x = s[0], y = s[1], a = s[2];

            if (a == 0) {
                if (y == 0 || find(arr, x, y - 1, 0) || find(arr, x - 1, y, 1) || find(arr, x, y, 1)) continue;
                return false;
            } else {
                if (find(arr, x, y - 1, 0) || find(arr, x + 1, y - 1, 0)
                        || (find(arr, x - 1, y, 1) && find(arr, x + 1, y, 1))) continue;
                return false;
            }
        }
        return true;
    }

    boolean find(List<int[]> arr, int x, int y, int a) {
        for (int[] s : arr) {
            if (s[0] == x && s[1] == y && s[2] == a) return true;
        }
        return false;
    }
}
