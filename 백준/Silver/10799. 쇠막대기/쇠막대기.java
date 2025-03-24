import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;
        int stick = 0;

        for (int i = 0; i < str.length(); i++) {
            char cha = str.charAt(i);
            if (cha == '(') {
                stick++;
            } else {
                stick--;
                if (str.charAt(i - 1) == '(') {
                    result += stick;
                } else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
