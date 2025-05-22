import java.io.*;
import java.sql.*;
import java.util.Arrays;
import java.util.Objects;

//02984
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] zeroArr = str.split("1");
        String[] oneArr = str.split("0");
        int zero = 0;
        int one = 0;

        for (String string : zeroArr) {
            if (!Objects.equals(string, "")) {
                zero++;
            }
        }
        for (String string : oneArr) {
            if (!Objects.equals(string, "")) {
                one++;
            }
        }
        System.out.println(Math.min(zero, one));

    }
}
