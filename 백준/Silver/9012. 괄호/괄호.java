import java.io.*;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int t=0; t<n;t++){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (int i=0; i<str.length(); i++){
                char cha = str.charAt(i);
                if (cha=='('){
                    stack.push(cha);
                }else {
                    if (stack.empty()){
                        System.out.println("NO");
                        flag=false;
                        break;
                    }
                    if(stack.pop()!='('){
                        System.out.println("NO");
                        flag=false;
                        break;
                    }
                }
            }
            if (!stack.empty()){
                flag=false;
                System.out.println("NO");
            }
            if (flag){
                System.out.println("YES");
            }
        }
        br.close();
    }
}