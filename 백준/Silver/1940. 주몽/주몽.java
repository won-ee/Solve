import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        
        int cnt = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) continue;
            int a = Integer.parseInt(arr[i]);
            
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == null) continue;
                int b = Integer.parseInt(arr[j]);
                
                if (a + b == m) {
                    arr[i] = null;
                    arr[j] = null;
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
