import java.util.*;

class Food implements Comparable<Food> {
    int time;
    int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    @Override
    public int compareTo(Food o) {
        return this.time - o.time;
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        long total = 0;
        for (int t : food_times) {
            total += t;
        }
        if (total <= k) return -1;

        PriorityQueue<Food> pq = new PriorityQueue<>();
        int n = food_times.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }

        long prev = 0;
        long size = n;

        while (!pq.isEmpty()) {
            long now = pq.peek().time;
            long spend = (now - prev) * size;
            if (k >= spend) {
                k -= spend;
                prev = now;
                pq.poll();
                size--;
            } else {
                break;
            }
        }

        if (size == 0) return -1;

        List<Food> remaining = new ArrayList<>();
        while (!pq.isEmpty()) {
            remaining.add(pq.poll());
        }

        remaining.sort(Comparator.comparingInt(f -> f.index));
        return remaining.get((int)(k % size)).index;
    }
}
