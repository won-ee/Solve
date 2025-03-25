import java.util.Arrays;

class Solution {
    public static String[] mergeSort(String[] arr){
        if (arr.length == 1) return arr;

        int mid = arr.length/2;
        String[] left = Arrays.copyOfRange(arr,0,mid);
        String[] right = Arrays.copyOfRange(arr,mid,arr.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left,right);
    }

    public static String[] merge(String[] left, String[] right){
        String[] merged = new String[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while(left.length>i && right.length>j){
            String l = left[i];
            String r = right[j];
            if ((r + l).compareTo(l + r) > 0) {
                merged[k++] = right[j++];
            } else {
                merged[k++] = left[i++];
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

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] strArr= new String[numbers.length];
        for (int i=0; i<numbers.length; i++){
            strArr[i] = numbers[i]+"";
        }
        
        strArr = mergeSort(strArr);
        
        if (strArr[0].equals("0")) return "0";

        for (int i=0; i<strArr.length; i++){
            answer.append(strArr[i]);
        }
        return answer.toString();
    }
}