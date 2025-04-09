import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str += ".";
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (int i=0; i<str.length(); i++){
            char cha = str.charAt(i);
            if (sb.length() == 4){
                ans.append("AAAA");
                sb.setLength(0);
            }
            if (cha=='.'){

                if (sb.isEmpty()) {
                    ans.append('.');
                    continue;
                };
                if (sb.length() == 2){
                    ans.append("BB").append(".");
                    sb.setLength(0);
                    continue;
                }else {
                    ans.setLength(0);
                    ans.append("-1");
                    break;
                }
            }
            sb.append(cha);
        }
        if (!ans.toString().equals("-1")){
            ans.delete(ans.length()-1,ans.length());
        }
        System.out.println(ans);
        br.close();
    }
}
