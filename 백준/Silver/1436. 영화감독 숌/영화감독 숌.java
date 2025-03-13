import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       String firstName = "666";
       int cnt = 0;
       int index = 0;
       while (cnt!=n){
           String temp = String.valueOf(index);
           int flag = 0;
           for (int i=0; i<temp.length(); i++){
               if(temp.charAt(i)=='6'){
                   flag+=1;
               }else {
                   flag=0;
               }
               if (flag==3){
                   cnt += 1;
               }
           }
           index++;
       }
        System.out.println(index-1);
    }
}
