import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder st = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int t=0; t<n; t++){
            int[] arr = new int[123];
            String str = br.readLine();
            for (int i=0; i<str.length(); i++){
                char ch = str.charAt(i);
                if (ch == ' ') continue;
                arr[ch] += 1;
            }
            char ans = '?';
            int max = 0;
            for (int i=0; i<123; i++){
                if (max<arr[i]){
                    max = arr[i];
                    ans = (char)i;
                } else if (max == arr[i]){
                    ans = '?';
                }
            }
            st.append(ans);
            st.append("\n");
        }
        System.out.println(st);
        br.close();
    }
}
