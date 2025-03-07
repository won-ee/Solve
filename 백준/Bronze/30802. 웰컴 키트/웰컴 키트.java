import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[6];

        for (int i=0; i<6; i++){
            arr[i] = sc.nextInt();;
        }

        int T = sc.nextInt();
        int P = sc.nextInt();
        int tShirt = 0;

        for (int size:arr){
            if (size==0) continue;
            if (size/T == 0){
                tShirt += 1;
            }else {
                tShirt+=(size/T);
                if (size%T!=0){
                    tShirt+=1;
                }
            }
        }
        System.out.println(tShirt);
        System.out.println(n/P + " " + n%P);

        sc.close();
    }
}