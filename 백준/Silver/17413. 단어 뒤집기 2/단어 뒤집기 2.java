import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder ans = new StringBuilder();
        StringBuilder strTemp = new StringBuilder();

        for (int i=0; i<str.length(); i++){

            char cha = str.charAt(i);

            if (cha == '<'){
                if (!strTemp.isEmpty()){
                    strTemp.reverse();
                    ans.append(strTemp);
                    strTemp = new StringBuilder();
                }
                for (int j=i; j<str.length(); j++){
                    char parentheses = str.charAt(j);
                    ans.append(parentheses);
                    if (parentheses == '>')break;
                    i++;
                }
                continue;
            }


            if (cha ==' ') {
                strTemp.reverse();
                ans.append(strTemp);
                strTemp = new StringBuilder();
                ans.append(" ");
                continue;
            }

            strTemp.append(cha);
        }


        if (!strTemp.isEmpty()){
            strTemp.reverse();
            ans.append(strTemp);
        }

        System.out.println(ans);
    }
}