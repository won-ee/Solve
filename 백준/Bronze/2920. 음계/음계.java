import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ascending = "12345678";
        String descending = "87654321";
        String temp ="";
        for (int i=0; i<8; i++){
            int a = sc.nextInt();
            temp = temp+a;
        }
        if (ascending.equals(temp)){
            System.out.println("ascending");
        } else if (descending.equals(temp)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}