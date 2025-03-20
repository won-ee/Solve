import java.io.*;
import java.util.Arrays;

public class Main {
    static Boolean[] isPrime;

    public static void isPrimeF(int n){
        isPrime = new Boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;
        for (int i=2; i<=Math.sqrt(n); i++){
            if(isPrime[i]){
                for (int j=i*i; j<=n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        isPrimeF(end);
        for (int i=start; i<=end; i++){
            if (isPrime[i]){
                sb.append(i);
                sb.append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
        br.close();
    }
}