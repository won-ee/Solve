import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            boolean[] used = new boolean[K];

            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);

                if (command == 'I') {
                    int value = Integer.parseInt(st.nextToken());
                    maxHeap.add(new int[]{value, i});
                    minHeap.add(new int[]{value, i});
                } else {
                    int value = Integer.parseInt(st.nextToken());
                    if (value == 1) {
                        while (!maxHeap.isEmpty() && used[maxHeap.peek()[1]]) {
                            maxHeap.poll();
                        }
                        if (!maxHeap.isEmpty()) {
                            used[maxHeap.poll()[1]] = true;
                        }
                    } else {
                        while (!minHeap.isEmpty() && used[minHeap.peek()[1]]) {
                            minHeap.poll();
                        }
                        if (!minHeap.isEmpty()) {
                            used[minHeap.poll()[1]] = true;
                        }
                    }
                }
            }

            while (!maxHeap.isEmpty() && used[maxHeap.peek()[1]]) {
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && used[minHeap.peek()[1]]) {
                minHeap.poll();
            }

            if (maxHeap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxHeap.peek()[0] + " " + minHeap.peek()[0]);
            }
        }
    }
}