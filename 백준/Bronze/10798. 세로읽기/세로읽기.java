import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();
        String[] arr = new String[5];
        int max = 0;
        for (int i=0; i<5; i++){
            String str = br.readLine();
            arr[i] = str;
            if (max<str.length()){
                max = str.length();
            }
        }

        for (int i=0; i<max; i++){
            for (int j=0; j<5; j++){
                if(arr[j].length()<=i)continue;
                ans.append(arr[j].charAt(i));
            }
        }
        System.out.print(ans);
        br.close();
    }
}
