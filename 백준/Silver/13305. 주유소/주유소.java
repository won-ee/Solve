import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        String[] tempToll = br.readLine().split(" ");
        String[] tempOil = br.readLine().split(" ");
        int[] km = new int[n-1];
        int[] oil = new int[n];

        for (int i=0; i<n; i++){
            if (i<n-1){
                km[i] = Integer.parseInt(tempToll[i]);
            }
            oil[i] = Integer.parseInt(tempOil[i]);
        }

        int minOil = oil[0] ;
        int ans = minOil * km[0];

        for (int i=1; i<n-1; i++){
            if (minOil >oil[i]){
                minOil = oil[i];
                ans += (minOil* km[i]);
            }else {
                ans += (minOil * km[i]);
            }
        }
        System.out.println(ans);
    }
}