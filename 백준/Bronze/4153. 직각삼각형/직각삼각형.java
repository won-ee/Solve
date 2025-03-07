import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            int sum = 0;
            List<Integer> arr = new ArrayList<>();

            for (int i=0; i<3; i++){
                int n = sc.nextInt();
                sum += n;
                arr.add(n);
            }
            if (sum ==0){
                break;
            }
            Collections.sort(arr);

            if ((arr.get(0) *arr.get(0)) + (arr.get(1)*arr.get(1))==arr.get(2)*arr.get(2)){
                System.out.println("right");
            }else {
                System.out.println("wrong");
            }

        }
        sc.close();
    }
}