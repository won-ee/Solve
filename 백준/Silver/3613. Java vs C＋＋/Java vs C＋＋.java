import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        StringBuilder ans = new StringBuilder();
        Boolean flag = null;
        for (int i=0; i<str.length(); i++){
            char cha = str.charAt(i);
            if(cha=='_'){
                if(flag !=null && !flag){
                    ans = new StringBuilder("Error!");
                    break;
                }
                if (i+1>=str.length() ||  i==0){
                    ans = new StringBuilder("Error!");
                    break;
                }
                int nextCha = (str.charAt(i+1));
                if (nextCha <97 || nextCha>122){
                    ans = new StringBuilder("Error!");
                    break;
                }

                char next = (char)(nextCha-32);
                ans.append(next);
                i++;
                flag = true;
                continue;
            }
            int alpa = cha;
            if (alpa >=65 &&  alpa <=90){
                if(flag !=null && flag){
                    ans = new StringBuilder("Error!");
                    break;
                }
                if(i==0){
                    ans = new StringBuilder("Error!");
                    break;
                }
                ans.append('_');
                ans.append((char)(alpa+32));
                flag=false;
                continue;
            }
            ans.append(cha);
        }
        System.out.println(ans);
        br.close();
    }
}