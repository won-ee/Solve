import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] coin = new int[n];
        for (int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);
        int cnt = 0;


        for(int i=n-1; i>=0; i--){
            if(k>=coin[i]){
                cnt += k/coin[i];
                k = k%coin[i];
            }
        }

        System.out.print(cnt);
        br.close();
    }
}
