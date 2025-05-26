import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int a = 0;
        int b= 0;
        for (int i=0; i<str.length()/2; i++){
            char cha = str.charAt(i);
            a += cha-48;
        }
        for (int i=str.length()/2; i<str.length(); i++){
            char cha = str.charAt(i);
            b += cha-48;
        }

        if (a==b){
            System.out.println("LUCKY");
        }else {
            System.out.println("READY");
        }
    }
}
