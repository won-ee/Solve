import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            Deque<String> dq = new ArrayDeque<>();
            if (n > 0) {
                StringTokenizer st = new StringTokenizer(arrStr.substring(1, arrStr.length() - 1), ",");
                while (st.hasMoreTokens()) {
                    dq.add(st.nextToken());
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    isReversed = !isReversed;
                } else { 
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        dq.pollLast();
                    } else {
                        dq.pollFirst();
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");
                while (!dq.isEmpty()) {
                    if (isReversed) {
                        sb.append(dq.pollLast());
                    } else {
                        sb.append(dq.pollFirst());
                    }
                    if (!dq.isEmpty()) {
                        sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}