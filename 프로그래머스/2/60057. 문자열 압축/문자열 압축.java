class Solution {
public int solution(String s) {
    int ans = s.length();

    for (int n = 1; n <= s.length() / 2; n++) {
        StringBuilder sb = new StringBuilder();
        String prev = s.substring(0, n);
        int cnt = 1;

        for (int i = n; i < s.length(); i += n) {
            int end = Math.min(i + n, s.length());
            String cur = s.substring(i, end);

            if (prev.equals(cur)) {
                cnt++;
            } else {
                if (cnt > 1) {
                    sb.append(cnt);
                }
                sb.append(prev);
                prev = cur;
                cnt = 1;
            }
        }

        if (cnt > 1) {
            sb.append(cnt);
        }
        sb.append(prev);

        ans = Math.min(ans, sb.length());
    }

    return ans;
}

}