import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String str = sc.next();
        BigInteger N = new BigInteger("0");

        for (int i=0; i<L; i++){
            char c = str.charAt(i);
            BigInteger a = BigInteger.valueOf((int)c-96);
            BigInteger b = BigInteger.valueOf(31).pow(i);
            BigInteger d = a.multiply(b);
            N = N.add(d);
        }
        System.out.println(N.remainder(BigInteger.valueOf(1234567891)));
    }
}