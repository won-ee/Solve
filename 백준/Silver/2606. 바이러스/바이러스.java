import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int idx = Integer.parseInt(br.readLine());
        int[][] arr = new int[computers+1][computers+1];
        int[] used = new int[computers+1];
        for (int i=0; i<idx; i++){
            String[] ar = br.readLine().split(" ");
            arr[Integer.parseInt(ar[0])][Integer.parseInt(ar[1])] = 1;
            arr[Integer.parseInt(ar[1])][Integer.parseInt(ar[0])] = 1;

        }

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        used[1] = 1;
        while (!que.isEmpty()){
            int now = que.poll();
            for (int i=0; i<computers+1; i++){
                if (arr[now][i]==1 && used[i]==0){
                    used[i] = 1;
                    que.add(i);
                }
            }
        }
        int ans =0;
        for (int i=2; i<computers+1; i++){
            if (used[i]==1)ans++;
        }
        System.out.print(ans);
    }
}