import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<T; i++){
            String str = sc.nextLine();
            int sum =0;
            int ans = 0;
            for (int j=0; j<str.length(); j++){
                if (str.charAt(j) == 'O'){
                    sum += 1;
                }else {
                    sum = 0;
                }
                ans += sum;
            }
            System.out.println(ans);
        }

        sc.close();
    }
}