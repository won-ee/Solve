import java.util.Stack;

class Solution {
    public String solution(String p) {
        // 1. 빈 문자열이면 반환
        if (p.isEmpty()) return "";

        // 2. u, v 분리
        int left = 0, right = 0;
        String u = "", v = "";

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        // 3. u가 올바른 괄호 문자열인지 확인
        if (check(u)) {
            // 3-1. u + 재귀(v)
            return u + solution(v);
        } else {
            // 4. 변환 수행
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(solution(v));
            sb.append(')');
            sb.append(reverse(u.substring(1, u.length() - 1)));
            return sb.toString();
        }
    }

    // 올바른 괄호 문자열인지 확인
    public boolean check(String p) {
        Stack<Character> stack = new Stack<>();
        for (char ch : p.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    // 괄호 방향 뒤집기
    public String reverse(String p) {
        StringBuilder sb = new StringBuilder();
        for (char c : p.toCharArray()) {
            if (c == '(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
}
