import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans=0;
        for (int i=1; i<4; i++){
            String str = br.readLine();
            if(str.matches("^[\\d]*$") == true){
                ans = Integer.parseInt(str) + 4-i;
                br.close();
                break;
            }
        }
        if (ans%3==0){
            if (ans%5==0){
                System.out.println("FizzBuzz");
            }else {
                System.out.println("Fizz");
            }
        }else {
            if (ans%5 ==0){
                System.out.println("Buzz");
            }else {
                System.out.println(ans);

            }
        }
    }
}