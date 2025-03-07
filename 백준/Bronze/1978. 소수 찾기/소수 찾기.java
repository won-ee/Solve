import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i=0; i<n; i++){
            int x = sc.nextInt();
            int flag = 0;
            for (int j=2; j<=x; j++){
                if (x%j==0) {flag += 1;}
            }
            if (flag == 1){
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}