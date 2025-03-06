import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[100];
        int sum = 0;
        for(int i=0; i<10; i++){
            int a = sc.nextInt();
            arr[a%42] += 1;
        }
        for(int ar:arr){
            if (ar !=0){
                sum += 1;
            }
        }
        System.out.println(sum);

        sc.close();
    }
}