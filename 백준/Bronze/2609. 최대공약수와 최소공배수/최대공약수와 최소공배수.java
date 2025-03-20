import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int gcd = gcd(a,b);
        System.out.println(gcd);
        System.out.println(a*b/gcd);
        br.close();
    }

    public static int gcd(int a, int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
}