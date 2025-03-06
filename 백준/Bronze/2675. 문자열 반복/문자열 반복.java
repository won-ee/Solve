import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i=0; i<T; i++){
            int n = sc.nextInt();
            String str = sc.next();
            for (int j=0; j<str.length(); j++){
                for (int k=0; k<n; k++){
                    System.out.print(str.charAt(j));
                }

            }
            System.out.println();
        }
        sc.close();
    }
}