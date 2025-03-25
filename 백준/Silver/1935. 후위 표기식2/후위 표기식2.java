import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Stack<Double> stack = new Stack<>();
        int[] arr = new int[n];

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<str.length(); i++){
            char cha = str.charAt(i);

            if (cha=='*'){
                double a = stack.pop();
                double b = stack.pop();
                stack.push(a*b);
            } else if (cha =='+') {
                double a = stack.pop();
                double b = stack.pop();
                stack.push(a+b);
            } else if (cha =='/') {
                double a = stack.pop();
                double b = stack.pop();
                stack.push(b/a);
            } else if (cha =='-') {
                double a = stack.pop();
                double b = stack.pop();
                stack.push(b-a);
            } else {
                stack.push((double)(arr[(int)cha-65]));
            }
        }
        String ans = String.format("%.2f", stack.pop());
        System.out.println(ans);
    }
}
