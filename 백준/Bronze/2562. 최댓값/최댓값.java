import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int n;
        int index =0;
        for (int i=1; i<10; i++){
            n = sc.nextInt();
            if (n >max){
                max = n;
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}