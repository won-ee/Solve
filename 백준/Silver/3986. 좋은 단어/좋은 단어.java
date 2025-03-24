import java.io.*;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int t=0; t<n; t++){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for (int i=0; i<str.length(); i++){
                char cha = str.charAt(i);
                if (!stack.empty()&&stack.peek()==cha){
                    stack.pop();
                    continue;
                }
                stack.push(cha);
            }
            if (stack.empty()) cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}