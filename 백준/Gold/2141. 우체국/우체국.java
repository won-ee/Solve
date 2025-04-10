import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        String[] strArr;

        long mid = 0;
        for (int i=0; i<n; i++){
            strArr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strArr[0]);
            arr[i][1] = Integer.parseInt(strArr[1]);
            mid += Integer.parseInt(strArr[1]);
        }
        Arrays.sort(arr,(a,b) -> {
            if (a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }else {
                return Integer.compare(a[1],b[1]);
            }
        });

        long person = 0;
        for (int[] ar : arr){
            person += ar[1];
            if (person * 2>=mid){
                System.out.println(ar[0]);
                break;
            }
        }
    }
}
