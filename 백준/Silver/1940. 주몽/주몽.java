import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int i = 0;
        int j = 1;
        int cnt = 0;
        while (i<arr.length){
            j = i+1;
            if (arr[i]==null)  {
                i++;
                continue;
            }

            int a = Integer.parseInt(arr[i]);
            while (j<arr.length){
                if(arr[j]==null){
                    j++;
                    continue;
                }
                int b = Integer.parseInt(arr[j]);
                if (a+b==m){
                    arr[i] = null;
                    arr[j] = null;
                    cnt++;
                    break;
                }
                j++;
            }
            i++;
        }
        System.out.println(cnt);
    }
}
