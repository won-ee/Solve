import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[91];
        for (int i=0; i<str.length(); i++){
            char cha = str.charAt(i);

            if ((int)cha>96){
                arr[((int)cha)-32] += 1;
            }else {
                arr[cha] += 1;
            }
        }

        char ans = '?';
        int max = 0;
        for (int i=0; i<91; i++){
            if (max<arr[i]){
                max = arr[i];
                ans = (char)i;
            }else if(max == arr[i]){
                ans = '?';
            }
        }
        System.out.println(ans);
    }
}