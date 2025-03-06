import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int [] arr = new int[10];
        String str = (a*b*c)+"";
        for (int i=0; i<str.length(); i++){
            int x = str.charAt(i)-'0';
            arr[x] += 1;
        }
        for (int i=0; i<10; i++){
            System.out.println(arr[i]);
        }
    }

}