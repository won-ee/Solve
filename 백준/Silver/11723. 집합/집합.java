import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[21];
        Arrays.fill(arr,false);
        for (int i=0; i<n; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            String command = st.nextToken();
            int num = -1;

            if (st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }
            if (num>0){
                if (Objects.equals(command, "add")){
                    if (!arr[num]) arr[num] = true;
                }else if(Objects.equals(command,"check")){
                    if (arr[num]) {
                        sb.append(1);
                        sb.append("\n");
                    }else {
                        sb.append(0);
                        sb.append("\n");
                    }
                }else if(Objects.equals(command,"remove")){
                    if (arr[num]) arr[num] = false;
                }else if(Objects.equals(command,"toggle")){
                    arr[num] = !arr[num];
                }
            }else {
                if (Objects.equals(command,"all")){
                    Arrays.fill(arr,1,21,true);
                }else {
                    Arrays.fill(arr,false);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
