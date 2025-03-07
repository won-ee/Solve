import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = n;
        for (int i=n; i>0; i--){
            String str = i+"";
            int sum = 0;
            for (int j=0; j<str.length(); j++){
                int x = str.charAt(j)-'0';
                sum += x;
            }
            if (n == i+sum){
                if (min>i){
                    min = i;
                }
            }
        }
        if(n==min){
            System.out.println(0);
        }else {
            System.out.println(min);
        }
    }
}