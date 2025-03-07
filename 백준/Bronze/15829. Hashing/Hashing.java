import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        String str = sc.next();
        int hash = 0;
        for (int i=0; i<L; i++){
            char c = str.charAt(i);
            hash += ((int)c-96)*(int)Math.pow(31,i);
        }
        System.out.println(hash);
    }
}