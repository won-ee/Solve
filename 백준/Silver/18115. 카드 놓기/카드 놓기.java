import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        String[] command = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i=n-1; i>=0; i--){
            switch (command[i]){
                case "1":
                    dq.addFirst(count++);
                    break;
                case "2":
                    int temp = dq.poll();
                    dq.addFirst(count++);
                    dq.addFirst(temp);
                    break;
                case "3":
                    dq.add(count++);
                    break;
            }
        }

        for (int i=0; i<n; i++){
            sb.append(dq.poll()).append(" ");
        }
        System.out.println(sb);
    }
}
