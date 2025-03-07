import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String str = sc.next();

            if(Objects.equals(str, "0")){
                break;
            }

            StringBuffer st = new StringBuffer(str);
            st.reverse();
            String reverseStr = st.toString();
            if (Objects.equals(reverseStr,str)){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
        sc.close();
    }
}