import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        StringBuilder st = new StringBuilder();

        for (int k=0; k<(str.length()%3); k++){
            str.insert(0, "0");
        }

        for (int i=str.length()-1; i>=0; i-=3){
            int ans = 0;
            for (int j=0; j<3; j++){
                int temp = str.charAt(i-j)-'0';
                if (j==0){
                    ans += temp;
                } else if(j==1){
                    ans += (temp * 2);
                }else{
                    ans += (temp * 4);
                }
            }
            st.append(ans);
        }

        st.reverse();
        System.out.print(st);
        sc.close();
    }
}