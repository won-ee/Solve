import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr = mergeSort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<arr.length; i++){
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[] mergeSort(int[] arr){
        if (arr.length==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left,right);
    }

    public static int[] merge(int[] left, int[] right){
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i<left.length && j<right.length){
            if(left[i]<right[j]){
                merged[k++] = left[i++];
            }else {
                merged[k++] = right[j++];
            }
        }

        while (i<left.length){
            merged[k++] = left[i++];
        }
        while (j<right.length){
            merged[k++] = right[j++];
        }
        return merged;
    }
}
