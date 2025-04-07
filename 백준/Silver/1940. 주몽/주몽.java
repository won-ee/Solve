import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(strArr[i]);

        }
        int left = 0;
        int right = n-1;
        int cnt = 0;
        Arrays.sort(arr);
        while (left<right){
            int sum = arr[left] + arr[right];
            if(sum<m){
                left++;
            } else if (sum>m) {
                right--;
            }else {
                cnt ++;
                left++;
                right--;
            }
        }
        System.out.println(cnt);
    }
}
