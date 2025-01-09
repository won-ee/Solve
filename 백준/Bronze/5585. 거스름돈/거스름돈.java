import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = Integer.parseInt(sc.next());
        sc.close();
        int charge = 1000 - price;
        int ans = 0;

        if (charge>=500){
            ans += charge/500;
            charge %= 500;
        }
        if (charge>=100){
            ans += charge/100;
            charge %= 100;
        }
        if (charge>=50){
            ans += charge/50;
            charge %= 50;
        }
        if (charge>=10){
            ans += charge/10;
            charge %= 10;
        }
        if (charge>=5){
            ans += charge/5;
            charge %= 5;
        }
        ans += charge;

        System.out.println(ans);
    }
}