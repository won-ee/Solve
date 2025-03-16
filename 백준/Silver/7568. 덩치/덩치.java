import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Entry[] arr = new Entry[n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int weight = Integer.parseInt(line[0]);
            int height = Integer.parseInt(line[1]);
            arr[i] = new Entry(weight, height);
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[j].weight > arr[i].weight && arr[j].height > arr[i].height) {
                    rank++;
                }
            }
            arr[i].rank = rank;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].rank + " ");
        }
    }

    static class Entry {
        int weight;
        int height;
        int rank;

        Entry(int weight, int height) {
            this.weight = weight;
            this.height = height;
            this.rank = 1;
        }
    }
}
