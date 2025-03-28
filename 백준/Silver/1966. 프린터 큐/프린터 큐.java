import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Entry {
        public final int priority;
        public final int idx;

        Entry(int priority, int idx) {
            this.priority = priority;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            String[] strArr = br.readLine().split(" ");
            Queue<Entry> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                queue.offer(new Entry(Integer.parseInt(strArr[i]), i));
            }

            int count = 0;

            while (!queue.isEmpty()) {
                Entry now = queue.poll();

                boolean flag = false;
                for (Entry e : queue) {
                    if (e.priority > now.priority) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    queue.offer(now);
                } else {
                    count++;
                    if (now.idx == m) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
