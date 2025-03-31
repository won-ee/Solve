import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();


        for (int i=0; i<str.length(); i++){
            left.push(str.charAt(i));
        }

        String command;

        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String[] commandArr = br.readLine().split(" ");
            command = commandArr[0];
            switch (command) {
                case "L":
                    if (left.empty()) continue;
                    right.push(left.pop());
                    break;
                case "D":
                    if (right.empty()) continue;
                    left.push(right.pop());
                    break;
                case "B":
                    if (left.empty()) continue;
                    left.pop();
                    break;
                case "P":
                    left.push(commandArr[1].charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.print(sb);
        br.close();
    }
}
